package co.nz.csoft.razorpay.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.apache.commons.codec.binary.Hex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import co.nz.csoft.razorpay.dto.AccommodationEnquiryDto;
import co.nz.csoft.razorpay.dto.BookingDto;
import co.nz.csoft.razorpay.dto.ExternalReservationDto;
import co.nz.csoft.razorpay.dto.PaymentDto;
import co.nz.csoft.razorpay.dto.PropertyDto;
import co.nz.csoft.razorpay.dto.RazorpayPaymentLinkRequest;
import co.nz.csoft.razorpay.dto.RazorpayPaymentLinkResponseDto;
import co.nz.csoft.razorpay.dto.RazorpayPaymentOrderDto;
import co.nz.csoft.razorpay.dto.RefundDto;
import co.nz.csoft.razorpay.dto.RoomDetail;
import co.nz.csoft.razorpay.dto.WhatsappDto;
import co.nz.csoft.razorpay.dto.WhatsappEnquiry;
import co.nz.csoft.razorpay.enums.BookingStatus;
import co.nz.csoft.razorpay.enums.PaymentMode;
import co.nz.csoft.razorpay.enums.PaymentStatus;
import co.nz.csoft.razorpay.service.ExternalAPIService;
import co.nz.csoft.razorpay.service.PaymentGatewayService;
import co.nz.csoft.razorpay.service.RazorpayPaymentOrderService;

@RestController
@RequestMapping("/api/razorpay")
public class RazorpayPaymentController {
	@Autowired
	private ExternalAPIService externalAPIService;
	@Autowired
	PaymentGatewayService paymentGatewayService;

	@Value("${bookone.API.url}")
	private String bookoneUrl;
	@Value("${whatsapp.send.url}")
	private String whatsappSendUrl;
	@Value("${thm.booking.url}")
	private String bookingUrl;

	@Value("${crm.base.url}")
	private String crmUrl;
	@Value("${external.reservation.url}")
	private String externalReservationBaseUrl;
	RestTemplate restTemplate = new RestTemplate();

	private static final Logger logger = LoggerFactory.getLogger(RazorpayPaymentController.class);

	@Value("${razorpay.webhook.secret}")
	private String webhookSecret;

	@Value("${lms.API.url}")
	private String lmsUrl;

	@Autowired
	private RazorpayPaymentOrderService razorpayPaymentService;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	LocalDateTime start = null;
	LocalDateTime finish = null;
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	/* Create Order in Razorpay Account */

	@PostMapping("/createOrder")
	ResponseEntity<?> createOrder(@RequestBody RazorpayPaymentOrderDto paymentDto) throws Exception {
		String createOrder = razorpayPaymentService.createOrder(paymentDto);
		return new ResponseEntity<>(createOrder, HttpStatus.OK);
	}

	/* Get Payment Data by OrderId */

	@GetMapping("/getByOrderId/{orderId}")
	ResponseEntity<?> fetchByOrderId(@PathVariable String orderId) throws Exception {
		String order = razorpayPaymentService.fetchByOrderId(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	/* Featch all Orders */

	@GetMapping("/orders")
	ResponseEntity<?> fetchAllOrders() throws RazorpayException {
		String fetchAllOrders = razorpayPaymentService.fetchAllOrders();
		return new ResponseEntity<>(fetchAllOrders, HttpStatus.OK);
	}

	/* Fetch Payments for an Order */

	@GetMapping("/order/{orderId}/payments")
	ResponseEntity<?> fetchPaymentsOfAnOrder(@PathVariable String orderId) throws Exception {
		String order = razorpayPaymentService.fetchPaymentsOfAnOrder(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@RequestMapping(value = "/paymentIntentBookone", method = RequestMethod.POST)
	public ResponseEntity<?> paymentIntentBookone(@RequestBody PaymentDto paymentDto) throws IOException, Exception {
		UUID uuid = UUID.randomUUID();
		start = LocalDateTime.now();
		log.info(" Start ** TransationID ** {} API ** Endpoint ** {} ** at ** {} ** received  {} ", uuid,
				"/api/razorpay/paymentIntentBookone", start, paymentDto);
		PropertyDto propertyDto = externalAPIService.findById(paymentDto.getPropertyId());
		PaymentDto paymentIntent = paymentGatewayService.paymentIntent(propertyDto, paymentDto);
		finish = LocalDateTime.now();
		log.info(" Finish ** TransationID ** {} API ** Endpoint ** {} ** at ** {} ", uuid,
				"/api/razorpay/paymentIntentBookone", finish);
		return new ResponseEntity<>(paymentIntent, HttpStatus.OK);
	}

	@RequestMapping(value = "/paymentIntentHotelmate", method = RequestMethod.POST)
	public ResponseEntity<?> paymentIntentHotelmate(@RequestBody PaymentDto paymentDto) throws IOException, Exception {
		UUID uuid = UUID.randomUUID();
		start = LocalDateTime.now();
		log.info(" Start ** TransationID ** {} API ** Endpoint ** {} ** at ** {} ** received  {} ", uuid,
				"/api/razorpay/paymentIntentHotelmate", start, paymentDto);
		PropertyDto propertyDto = externalAPIService.findHotelMatePropertyById(paymentDto.getPropertyId());
		PaymentDto paymentIntent = paymentGatewayService.paymentIntent(propertyDto, paymentDto);
		finish = LocalDateTime.now();
		log.info(" Finish ** TransationID ** {} API ** Endpoint ** {} ** at ** {} ", uuid,
				"/api/razorpay/paymentIntentHotelmate", finish);
		return new ResponseEntity<>(paymentIntent, HttpStatus.OK);
	}

	@PostMapping("/hotelmate/refund")
	public ResponseEntity<?> hotelmateRefund(@RequestBody RefundDto refundDto, @RequestParam Long propertyId) {
		try {
			PropertyDto property = externalAPIService.findHotelMatePropertyById(propertyId);
			RefundDto response = paymentGatewayService.refundPayment(property, refundDto);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@PostMapping("/bookone/refund")
	public ResponseEntity<?> bookoneRefund(@RequestBody RefundDto refundDto, @RequestParam Long propertyId) {
		try {
			PropertyDto property = externalAPIService.findById(propertyId);
			RefundDto response = paymentGatewayService.refundPayment(property, refundDto);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	private void createBookingFromCapturedPayment(String bookingId, JSONObject payment) throws Exception {
		Long enquiryId = Long.parseLong(bookingId);
		logger.info("🔍 Received numeric bookingId/enquiryId directly: {}", enquiryId);

		RestTemplate restTemplate = new RestTemplate();
		String enquiryUrl = crmUrl + "/api/v1/accommodationEnquiry/" + enquiryId;
		AccommodationEnquiryDto enquiryDto = restTemplate.getForObject(enquiryUrl, AccommodationEnquiryDto.class);

		if (enquiryDto == null) {
			logger.warn("Enquiry not found for ID: {}", enquiryId);
			return;
		}
		enquiryDto.setPaymentStatus(PaymentStatus.Paid); 
		enquiryDto.setStatus("Booked");
		enquiryDto.setFromTime(java.sql.Date.valueOf(LocalDate.parse(enquiryDto.getCheckInDate())));
enquiryDto.setToTime(java.sql.Date.valueOf(LocalDate.parse(enquiryDto.getCheckOutDate())));
		// ✅ Update enquiry back to CRM
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<AccommodationEnquiryDto> updateRequest = new HttpEntity<>(enquiryDto, headers);

		String updateUrl = crmUrl + "/api/v1/accommodationEnquiry";
		ResponseEntity<AccommodationEnquiryDto> updateResponse =
		        restTemplate.exchange(updateUrl, HttpMethod.POST, updateRequest, AccommodationEnquiryDto.class);

		if (updateResponse.getStatusCode().is2xxSuccessful()) {
		    logger.info("✅ Enquiry payment status updated to PAID for ID: {}", enquiryDto.getEnquiryId());
		} else {
		    logger.warn("⚠️ Failed to update payment status for Enquiry ID: {}. Response: {}",
		            enquiryDto.getEnquiryId(), updateResponse.getStatusCode());
		}
		BookingDto bookingDto = new BookingDto();
		bookingDto.setPropertyId(enquiryDto.getBookingPropertyId());

		String fromName = enquiryDto.getFromName();
		if (fromName != null && !fromName.trim().isEmpty()) {
			String[] parts = fromName.trim().split("\\s+");
			if (parts.length >= 2) {
				bookingDto.setLastName(parts[parts.length - 1]);
				bookingDto.setFirstName(String.join(" ", Arrays.copyOfRange(parts, 0, parts.length - 1)));
			} else {
				bookingDto.setFirstName(fromName.trim());
				bookingDto.setLastName("");
			}
		}

		bookingDto.setCreatedDate(new Date());
		bookingDto.setFromDate(java.sql.Date.valueOf(enquiryDto.getCheckInDate()));
		bookingDto.setToDate(java.sql.Date.valueOf(enquiryDto.getCheckOutDate()));

		LocalDate checkIn = LocalDate.parse(enquiryDto.getCheckInDate());
		LocalDate checkOut = LocalDate.parse(enquiryDto.getCheckOutDate());
		long noOfNights = ChronoUnit.DAYS.between(checkIn, checkOut);
		bookingDto.setNoOfNights((int) (noOfNights == 0 ? 1 : noOfNights));
		bookingDto.setFromDate(java.sql.Date.valueOf(LocalDate.parse(enquiryDto.getCheckInDate())));
		bookingDto.setToDate(java.sql.Date.valueOf(LocalDate.parse(enquiryDto.getCheckOutDate())));
		bookingDto.setFromTime(java.sql.Date.valueOf(LocalDate.parse(enquiryDto.getCheckInDate())));
		bookingDto.setToTime(java.sql.Date.valueOf(LocalDate.parse(enquiryDto.getCheckOutDate())));
		bookingDto.setMobile(enquiryDto.getMobile());
		bookingDto.setRoomId(enquiryDto.getRoomId());
		bookingDto.setModeOfPayment("Razorpay");

		String amountStr = String.valueOf(payment.optInt("amount") / 100.0); // INR
		// BigDecimal roomPrice = new BigDecimal(amountStr);
		BigDecimal roomPrice = enquiryDto.getRoomPrice();
		bookingDto.setRoomPrice(enquiryDto.getRoomPrice());
		bookingDto.setRoomTariffBeforeDiscount(enquiryDto.getRoomPrice());
		bookingDto.setNoOfRooms(enquiryDto.getNoOfRooms());
		bookingDto.setNoOfPersons(enquiryDto.getNoOfPerson());
		bookingDto.setNoOfChildren(enquiryDto.getNoOfChildren());
		bookingDto.setEmail(enquiryDto.getEmail());
		bookingDto.setPlanCode(enquiryDto.getPlanCode());
		bookingDto.setCurrency("INR");
		bookingDto.setExternalSite("WebSite");
		bookingDto.setNotes(enquiryDto.getSpecialNotes());
		BigDecimal baseAmount = roomPrice.multiply(BigDecimal.valueOf(bookingDto.getNoOfRooms()))
				.multiply(BigDecimal.valueOf(bookingDto.getNoOfNights()));
		BigDecimal taxRate = roomPrice.doubleValue() < 7501 ? new BigDecimal("0.05") : new BigDecimal("0.18");
		BigDecimal taxAmount = baseAmount.multiply(taxRate);
		BigDecimal totalAmount = baseAmount.add(taxAmount);

		bookingDto.setTaxAmount(taxAmount);
		bookingDto.setTotalAmount(totalAmount);
		bookingDto.setPayableAmount(totalAmount);
		if (bookingDto.getExtraPersonCharge() == null) {
			bookingDto.setExtraPersonCharge(BigDecimal.ZERO);
		}

		if (bookingDto.getExtraChildCharge() == null) {
			bookingDto.setExtraChildCharge(BigDecimal.ZERO);
		}

		// bookingDto.setNotes("whatsapp booking");
		BigDecimal paidAmount = BigDecimal.valueOf(payment.optInt("amount")).divide(BigDecimal.valueOf(100));
		bookingDto.setAdvanceAmount(paidAmount);
		bookingDto.setRoomTariffAmountPaid(paidAmount);

		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		try {
			// ✅ Print request payload
			String requestJson = mapper.writeValueAsString(bookingDto);
			System.out.println("Request Payload: " + requestJson);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HttpEntity<BookingDto> bookingRequest = new HttpEntity<>(bookingDto, headers);

		ResponseEntity<BookingDto> bookingResponse = restTemplate.postForEntity(bookingUrl + "/api/thm/booking",
				bookingRequest, BookingDto.class);

		// ✅ Print response payload
		if (bookingResponse != null) {
			System.out.println("Response Status: " + bookingResponse.getStatusCode());

			if (bookingResponse.getBody() != null) {
				try {
					String responseJson = mapper.writeValueAsString(bookingResponse.getBody());
					System.out.println("Response Payload: " + responseJson);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (bookingResponse.getStatusCode().is2xxSuccessful() && bookingResponse.getBody() != null) {
			BookingDto createdBooking = bookingResponse.getBody();
			String createdBookingId = String.valueOf(bookingResponse.getBody().getId());
			logger.info("✅ Booking created successfully with ID: {}", createdBookingId);
			 try {
		            String whatsappEnquiryUrl =
		                    "https://notification.uat.bookone.io/api/whatsapp-enquiry/accommodation/" + enquiryId;

		            ResponseEntity<WhatsappEnquiry> whatsappResponse =
		                    restTemplate.getForEntity(whatsappEnquiryUrl, WhatsappEnquiry.class);

		            if (whatsappResponse.getStatusCode().is2xxSuccessful() && whatsappResponse.getBody() != null) {
		                WhatsappEnquiry whatsappEnquiry = whatsappResponse.getBody();

		                // 🔹 Step 2: Update fields
		                whatsappEnquiry.setBookingConvert("yes");
		                whatsappEnquiry.setPaidAmount(createdBooking.getAdvanceAmount());

		                // 🔹 Step 3: Push update back
		                HttpHeaders notifyHeaders = new HttpHeaders();
		                notifyHeaders.setContentType(MediaType.APPLICATION_JSON);

		                HttpEntity<WhatsappEnquiry> notifyRequest = new HttpEntity<>(whatsappEnquiry, notifyHeaders);
		                String updateWhatsappUrl = "https://notification.uat.bookone.io/api/whatsapp-enquiry";

		                ResponseEntity<WhatsappEnquiry> notifyUpdateResponse =
		                        restTemplate.exchange(updateWhatsappUrl, HttpMethod.POST, notifyRequest, WhatsappEnquiry.class);

		                if (notifyUpdateResponse.getStatusCode().is2xxSuccessful()) {
		                    logger.info("✅ WhatsappEnquiry updated successfully for enquiryId {}", enquiryId);
		                } else {
		                    logger.warn("⚠️ Failed to update WhatsappEnquiry for enquiryId {}. Response: {}",
		                            enquiryId, notifyUpdateResponse.getStatusCode());
		                }
		            } else {
		                logger.warn("⚠️ WhatsappEnquiry not found for enquiryId {}", enquiryId);
		            }
		        } catch (Exception ex) {
		            logger.error("❌ Failed to update WhatsappEnquiry for enquiryId {}", enquiryId, ex);
		        }

			ExternalReservationDto externalReservation = new ExternalReservationDto();
			externalReservation.setCheckinDate(createdBooking.getFromDate().toString());
			externalReservation.setCheckoutDate(createdBooking.getToDate().toString());
			externalReservation.setCurrency(createdBooking.getCurrency());
			externalReservation.setEmail(createdBooking.getEmail());
			externalReservation.setTotalAmount(createdBooking.getTotalAmount());
			externalReservation.setCouponCode(createdBooking.getCouponCode());
			externalReservation.setPromotionName(createdBooking.getPromotionName());
			externalReservation.setAmountBeforeTax(createdBooking.getBeforeTaxAmount());
			externalReservation.setCreatedTimestamp(createdBooking.getCreatedDate());
			externalReservation.setChannelId("9");
			externalReservation.setPaidAmount(createdBooking.getAdvanceAmount());
			// externalReservation.setLastModifiedBy("hotelmate");
			// externalReservation.setDiscountAmount(createdBooking.getDiscountAmount());
			externalReservation.setModeOfPayment("Card");
			externalReservation.setOtaReservationId("WhatsApp-" + createdBooking.getId());
			externalReservation.setPropertyId(String.valueOf(createdBooking.getPropertyId()));
			externalReservation.setPropertyName(createdBooking.getBusinessName());
			externalReservation.setFirstName(createdBooking.getFirstName());
			externalReservation.setLastName(createdBooking.getLastName());
			externalReservation.setBookoneReservationId(createdBooking.getPropertyReservationNumber());
			externalReservation.setContactNumber(createdBooking.getMobile());
			externalReservation.setPropertyBusinessEmail(createdBooking.getBusinessEmail());
			externalReservation.setExternalTransactionId("WhatsApp-" + createdBooking.getId());
			externalReservation.setCreatedBy("hotelmate");
			externalReservation.setTaxAmount(createdBooking.getTaxAmount());
			externalReservation.setNoOfPerson(String.valueOf(createdBooking.getNoOfPersons()));
			externalReservation.setResType("");
			externalReservation.setOtaName("Website");
			externalReservation.setBookingStatus("BOOKED");
			externalReservation.setPayloadType("json");
			externalReservation.setNotes(createdBooking.getNotes());
			externalReservation.setModeOfPayment("razorpay");
			// 👉 RoomDetails mapping
			RoomDetail roomDetails = new RoomDetail();
			roomDetails.setCheckinDate(createdBooking.getFromDate().toString());
			roomDetails.setCheckoutDate(createdBooking.getToDate().toString());
			roomDetails.setNoOfRooms(createdBooking.getNoOfRooms());
			roomDetails.setNoOfadult(createdBooking.getNoOfPersons());
			roomDetails.setNoOfchild(createdBooking.getNoOfChildren());
			roomDetails.setPlan(createdBooking.getRoomRatePlanName());
			roomDetails.setRoomRate(createdBooking.getRoomPrice().doubleValue());
			roomDetails.setRoomTypeId(String.valueOf(createdBooking.getRoomId()));
			roomDetails.setRoomTypeName(createdBooking.getRoomName());

			externalReservation.getRoomDetails().add(roomDetails);

			// 👉 Services (if any)
			// externalReservation.setServices(createdBooking.getServices()); // assuming
			// BookingDto has services list

			// ✅ Call external reservation API
			HttpHeaders extHeaders = new HttpHeaders();
			extHeaders.setContentType(MediaType.APPLICATION_JSON);
			List<ExternalReservationDto> externalReservationList = Collections.singletonList(externalReservation);

			HttpEntity<List<ExternalReservationDto>> externalReq = new HttpEntity<>(externalReservationList,
					extHeaders);

			String externalReservationUrl = externalReservationBaseUrl + "/api/external/reservation/";

			try {
				ResponseEntity<String> extResponse = restTemplate.postForEntity(externalReservationUrl, externalReq,
						String.class);

				logger.info("📩 ExternalReservation API Response: {}", extResponse.getStatusCode());
				if (extResponse.getBody() != null) {
					logger.info("📩 Response Body: {}", extResponse.getBody());
				}
			} catch (Exception ex) {
				logger.error("❌ Failed to call ExternalReservation API", ex);
			}
		}
	}
		/*
		 * try { // Step 1: Generate voucher String voucherApiUrl = bookingUrl +
		 * "/api/thm/generateBookingVoucher?bookingId=" + createdBookingId;
		 * ResponseEntity<String> voucherResponse =
		 * restTemplate.getForEntity(voucherApiUrl, String.class);
		 * 
		 * if (voucherResponse.getStatusCode().is2xxSuccessful() &&
		 * voucherResponse.getBody() != null) { JSONObject voucherJson = new
		 * JSONObject(voucherResponse.getBody());
		 * 
		 * if (voucherJson.has("voucherUrl")) { String voucherUrl =
		 * voucherJson.getString("voucherUrl"); logger.info("✅ Voucher generated: {}",
		 * voucherUrl);
		 * 
		 * // Step 2: Update booking with voucher URL BookingDto updatedBooking =
		 * bookingResponse.getBody(); updatedBooking.setVoucherUrl(voucherUrl);
		 * 
		 * HttpEntity<BookingDto> updateRequest = new HttpEntity<>(updatedBooking,
		 * headers); String url = bookingUrl + "/api/thm/booking"; ResponseEntity<Void>
		 * response = restTemplate.postForEntity(url, updateRequest, Void.class);
		 * 
		 * // Step 3: Send WhatsApp confirmation after voucher is ready
		 * sendBookingConfirmedWhatsApp(enquiryDto, createdBookingId, paidAmount,
		 * voucherUrl); } else {
		 * logger.warn("⚠ No voucherUrl found in voucher API response: {}",
		 * voucherJson); } } else {
		 * logger.error("❌ Failed to generate booking voucher: {}",
		 * voucherResponse.getStatusCode()); } } catch (Exception e) {
		 * logger.error("🚨 Error while generating or updating voucher URL", e); }
		 */
	
	// }

	/*
	 * private void createBookingFromCapturedPayment(String bookingId, JSONObject
	 * payment) throws Exception { Long enquiryId = Long.parseLong(bookingId);
	 * logger.info("🔍 Received numeric bookingId/enquiryId directly: {}",
	 * enquiryId);
	 * 
	 * RestTemplate restTemplate = new RestTemplate(); String enquiryUrl = crmUrl +
	 * "/api/v1/accommodationEnquiry/" + enquiryId; AccommodationEnquiryDto
	 * enquiryDto = restTemplate.getForObject(enquiryUrl,
	 * AccommodationEnquiryDto.class);
	 * 
	 * if (enquiryDto == null) { logger.warn("Enquiry not found for ID: {}",
	 * enquiryId); return; }
	 * 
	 * // 🔎 Step 1: Check availability before creating booking String checkUrl =
	 * bookingUrl + "/api/thm/checkAvailability/" +
	 * enquiryDto.getBookingPropertyId() + "?fromDate=" +
	 * enquiryDto.getCheckInDate() + "&toDate=" + enquiryDto.getCheckOutDate() +
	 * "&noOfRooms=" + enquiryDto.getNoOfRooms() + "&noOfPersons=" +
	 * enquiryDto.getNoOfPerson() + "&noOfChildren=" + enquiryDto.getNoOfChildren();
	 * 
	 * logger.info("🔎 Checking availability at: {}", checkUrl);
	 * ResponseEntity<String> availabilityResponse =
	 * restTemplate.getForEntity(checkUrl, String.class);
	 * 
	 * if (!availabilityResponse.getStatusCode().is2xxSuccessful() ||
	 * availabilityResponse.getBody() == null) {
	 * logger.error("❌ Failed to check availability. Status: {}",
	 * availabilityResponse.getStatusCode()); return; }
	 * 
	 * JSONObject availabilityJson = new JSONObject(availabilityResponse.getBody());
	 * boolean available = availabilityJson.optBoolean("available", false);
	 * 
	 * if (!available) {
	 * logger.warn("⚠ No availability for propertyId={} from {} to {}",
	 * enquiryDto.getBookingPropertyId(), enquiryDto.getCheckInDate(),
	 * enquiryDto.getCheckOutDate()); return; }
	 * 
	 * logger.info("✅ Availability confirmed. Proceeding to create booking...");
	 * 
	 * // 🔎 Step 2: Prepare booking DTO BookingDto bookingDto = new BookingDto();
	 * bookingDto.setPropertyId(enquiryDto.getBookingPropertyId());
	 * 
	 * String fromName = enquiryDto.getFromName(); if (fromName != null &&
	 * !fromName.trim().isEmpty()) { String[] parts = fromName.trim().split("\\s+");
	 * if (parts.length >= 2) { bookingDto.setLastName(parts[parts.length - 1]);
	 * bookingDto.setFirstName(String.join(" ", Arrays.copyOfRange(parts, 0,
	 * parts.length - 1))); } else { bookingDto.setFirstName(fromName.trim());
	 * bookingDto.setLastName(""); } }
	 * 
	 * bookingDto.setCreatedDate(new Date());
	 * bookingDto.setFromDate(java.sql.Date.valueOf(enquiryDto.getCheckInDate()));
	 * bookingDto.setToDate(java.sql.Date.valueOf(enquiryDto.getCheckOutDate()));
	 * 
	 * LocalDate checkIn = LocalDate.parse(enquiryDto.getCheckInDate()); LocalDate
	 * checkOut = LocalDate.parse(enquiryDto.getCheckOutDate()); long noOfNights =
	 * ChronoUnit.DAYS.between(checkIn, checkOut); bookingDto.setNoOfNights((int)
	 * (noOfNights == 0 ? 1 : noOfNights));
	 * 
	 * bookingDto.setMobile(enquiryDto.getMobile());
	 * bookingDto.setRoomId(enquiryDto.getRoomId());
	 * 
	 * String amountStr = String.valueOf(payment.optInt("amount") / 100.0); // INR
	 * BigDecimal roomPrice = new BigDecimal(amountStr);
	 * bookingDto.setRoomPrice(roomPrice);
	 * 
	 * bookingDto.setNoOfRooms(enquiryDto.getNoOfRooms());
	 * bookingDto.setNoOfPersons(enquiryDto.getNoOfPerson());
	 * bookingDto.setNoOfChildren(enquiryDto.getNoOfChildren());
	 * bookingDto.setEmail(enquiryDto.getEmail());
	 * bookingDto.setPlanCode(enquiryDto.getPlanCode());
	 * bookingDto.setCurrency("INR"); bookingDto.setExternalSite("whatsapp");
	 * 
	 * BigDecimal baseAmount =
	 * roomPrice.multiply(BigDecimal.valueOf(bookingDto.getNoOfRooms()))
	 * .multiply(BigDecimal.valueOf(bookingDto.getNoOfNights())); BigDecimal taxRate
	 * = roomPrice.doubleValue() < 7501 ? new BigDecimal("0.12") : new
	 * BigDecimal("0.18"); BigDecimal taxAmount = baseAmount.multiply(taxRate);
	 * BigDecimal totalAmount = baseAmount.add(taxAmount);
	 * 
	 * bookingDto.setTaxAmount(taxAmount); bookingDto.setTotalAmount(totalAmount);
	 * bookingDto.setPayableAmount(totalAmount);
	 * bookingDto.setNotes("whatsapp booking"); BigDecimal paidAmount =
	 * BigDecimal.valueOf(payment.optInt("amount")).divide(BigDecimal.valueOf(100));
	 * bookingDto.setAdvanceAmount(paidAmount);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<BookingDto>
	 * bookingRequest = new HttpEntity<>(bookingDto, headers);
	 * 
	 * // 🔎 Step 3: Create booking ResponseEntity<BookingDto> bookingResponse =
	 * restTemplate.postForEntity( bookingUrl + "/api/thm/booking", bookingRequest,
	 * BookingDto.class);
	 * 
	 * if (bookingResponse.getStatusCode().is2xxSuccessful() &&
	 * bookingResponse.getBody() != null) { String createdBookingId =
	 * String.valueOf(bookingResponse.getBody().getId());
	 * logger.info("✅ Booking created successfully with ID: {}", createdBookingId);
	 * 
	 * /* try { // Step 1: Generate voucher String voucherApiUrl = bookingUrl +
	 * "/api/thm/generateBookingVoucher?bookingId=" + createdBookingId;
	 * ResponseEntity<String> voucherResponse =
	 * restTemplate.getForEntity(voucherApiUrl, String.class);
	 * 
	 * if (voucherResponse.getStatusCode().is2xxSuccessful() &&
	 * voucherResponse.getBody() != null) { JSONObject voucherJson = new
	 * JSONObject(voucherResponse.getBody());
	 * 
	 * if (voucherJson.has("voucherUrl")) { String voucherUrl =
	 * voucherJson.getString("voucherUrl"); logger.info("✅ Voucher generated: {}",
	 * voucherUrl);
	 * 
	 * // Step 2: Update booking with voucher URL BookingDto updatedBooking =
	 * bookingResponse.getBody(); updatedBooking.setVoucherUrl(voucherUrl);
	 * 
	 * HttpEntity<BookingDto> updateRequest = new HttpEntity<>(updatedBooking,
	 * headers); String url = bookingUrl + "/api/thm/booking"; ResponseEntity<Void>
	 * response = restTemplate.postForEntity(url, updateRequest, Void.class);
	 * 
	 * // Step 3: Send WhatsApp confirmation after voucher is ready
	 * sendBookingConfirmedWhatsApp(enquiryDto, createdBookingId, paidAmount,
	 * voucherUrl); } else {
	 * logger.warn("⚠ No voucherUrl found in voucher API response: {}",
	 * voucherJson); } } else {
	 * logger.error("❌ Failed to generate booking voucher: {}",
	 * voucherResponse.getStatusCode()); } } catch (Exception e) {
	 * logger.error("🚨 Error while generating or updating voucher URL", e); }
	 */
	// }
	// }

	private void sendBookingConfirmedWhatsApp(AccommodationEnquiryDto enquiryDto, String bookingId,
			BigDecimal paidAmount, String voucherUrl) throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode payload = objectMapper.createObjectNode();

		payload.put("messaging_product", "whatsapp");
		payload.put("to", enquiryDto.getMobile());
		payload.put("type", "template");

		// Template section
		ObjectNode template = payload.putObject("template");
		template.put("name", "booking_confirmed_paid");

		ObjectNode language = template.putObject("language");
		language.put("code", "en");

		ArrayNode components = template.putArray("components");

		// 1️⃣ Header with document
		ObjectNode header = components.addObject();
		header.put("type", "header");
		ArrayNode headerParams = header.putArray("parameters");

		ObjectNode documentParam = headerParams.addObject();
		documentParam.put("type", "document");

		ObjectNode document = documentParam.putObject("document");
		document.put("link", voucherUrl);

		// Auto-generate filename from URL
		String filename = voucherUrl.substring(voucherUrl.lastIndexOf("/") + 1);
		document.put("filename", filename);

		// 2️⃣ Body with parameters
		ObjectNode body = components.addObject();
		body.put("type", "body");
		ArrayNode bodyParams = body.putArray("parameters");

		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getFromName()));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getPropertyName()));
		bodyParams.addObject().put("type", "text").put("text", safeText(bookingId));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getCheckInDate()));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getCheckOutDate()));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getNoOfPerson()));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getNoOfChildren()));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getNoOfRooms()));
		bodyParams.addObject().put("type", "text").put("text", safeText(enquiryDto.getRoomType()));
		bodyParams.addObject().put("type", "text").put("text",
				String.format("%,.0f", paidAmount != null ? paidAmount : BigDecimal.ZERO));

		// 3️⃣ Send to WhatsApp Graph API
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(
				"EAACgeuhlGgwBO7z8rNwZCv0OBWPHNXrpiX3J3BSyyrlYGZBW68J6d2FCE9OfcGtQ2cTTsR10dveH0tyrJvatDLIXLTLoc1hEGqNryp8DrMSk0FZCi46PAXTyqF8r1vCtSZA4ECh6RBkfZCJyLw4Dktl9B1xHe510OtZBOeUyf98GRMVOL7xLZAXZCKazub3HTIdPPr9CJ00DbCCxcWtv");

		HttpEntity<String> requestEntity = new HttpEntity<>(objectMapper.writeValueAsString(payload), headers);

		ResponseEntity<String> apiResponse = restTemplate.postForEntity(
				"https://graph.facebook.com/v22.0/110126672103776/messages", requestEntity, String.class);

		logger.info("📩 WhatsApp booking confirmation sent. API Response: {}", apiResponse.getBody());
	}

	private String safeText(Object value) {
		return value == null ? "-" : value.toString();
	}

	@RequestMapping(value = "/webhook", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> handleWebhook(@RequestBody(required = false) String payload,
			@RequestHeader(value = "X-Razorpay-Signature", required = false) String signature,
			HttpServletRequest request) {

		if ("GET".equalsIgnoreCase(request.getMethod())) {
			logger.info("User redirected after payment. Showing thank you page.");
			String html = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Thank You</title><style>body{margin:0;padding:0;height:100vh;background:linear-gradient(to right,#e0f7fa,#fffde7);font-family:'Segoe UI',Tahoma,Geneva,Verdana,sans-serif;display:flex;justify-content:center;align-items:center;color:#333}.message-box{text-align:center;background:#fff;padding:30px 40px;border-radius:12px;box-shadow:0 8px 20px rgba(0,0,0,0.1)}.message-box h1{font-size:26px;color:#2e7d32;margin:0}.check-icon{font-size:40px;color:#4caf50;margin-bottom:10px}</style></head><body><div class=\"message-box\"><h1>Thank you! Your payment was successful.</h1></div></body></html>";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.TEXT_HTML);
			return new ResponseEntity<>(html, headers, HttpStatus.OK);
		}

		logger.info("Incoming Webhook Payload: {}", payload);
		logger.info("Incoming Signature Header: {}", signature);

		try {
			JSONObject json = new JSONObject(payload);
			String event = json.getString("event");
			if ("payment.captured".equals(event)) {
				JSONObject payment = json.getJSONObject("payload").getJSONObject("payment").getJSONObject("entity");
				JSONObject notes = payment.optJSONObject("notes");
				if (notes != null) {
					String policyName = notes.optString("policy_name", "");
					if (policyName.toLowerCase().contains("subscription")) {

						// Extract invoiceId
						String invoiceId = null;
						Pattern p = Pattern.compile("invoiceid[:\\s]+(.+)$", Pattern.CASE_INSENSITIVE);
						Matcher m = p.matcher(policyName);
						if (m.find()) {
							invoiceId = m.group(1).trim();
						}

						if (invoiceId != null && !invoiceId.isEmpty()) {

							BigDecimal paidAmount = BigDecimal.ZERO;
							boolean partialPaid = false;
							boolean failed = false;

							try {
								int amountPaise = payment.optInt("amount", 0);
								paidAmount = BigDecimal.valueOf(amountPaise).divide(BigDecimal.valueOf(100));
							} catch (Exception ignore) {}

							// FAILED PAYMENT
							if ("failed".equalsIgnoreCase(payment.optString("status"))) {
								failed = true;
							}

							// PARTIAL PAYMENT CHECK
							BigDecimal captured = BigDecimal.valueOf(payment.optInt("amount_captured", 0)).divide(BigDecimal.valueOf(100));
							partialPaid = (captured.compareTo(paidAmount) < 0);

							logger.info(
									"Subscription Webhook | invoiceId={} | amount={} | partialPaid={} | failed={}",
									invoiceId, paidAmount, partialPaid, failed
							);

							try {
								externalAPIService.sendSubscriptionPaymentWebhook(invoiceId, paidAmount, failed, partialPaid);
							} catch (Exception ex) {
								logger.error("Failed to send subscription webhook for invoiceId=" + invoiceId, ex);
							}
						}
					}
				}

				if (notes != null && notes.has("booking_id")) {
					String bookingId = notes.optString("booking_id");
					logger.info("🔄 Detected payment.captured with booking_id: {}", bookingId);

					try {
						createBookingFromCapturedPayment(bookingId, payment);
						return ResponseEntity.ok("Booking created from payment.captured");
					} catch (Exception ex) {
						logger.error("❌ Error creating booking from payment.captured", ex);
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Booking creation failed");
					}
				}
				if (notes != null && notes.has("enquiryId")) {
					Long enquiryId = notes.optLong("enquiryId");
					logger.info("🔹 Updating enquiry payment status for enquiryId={}", enquiryId);

					try {
						// Fetch the enquiry first
						String getEnquiryUrl = lmsUrl + "/api/v1/accommodationEnquiry/" + enquiryId;
						ResponseEntity<AccommodationEnquiryDto> enquiryResponse = restTemplate
								.getForEntity(getEnquiryUrl, AccommodationEnquiryDto.class);

						AccommodationEnquiryDto enquiry = enquiryResponse.getBody();

						if (enquiry != null) {
							// ✅ Check if enquiry belongs to a group
							if (enquiry.getGroupEnquiryId() != null) {
								Long groupEnquiryId = enquiry.getGroupEnquiryId();
								logger.info("🔹 Enquiry belongs to groupEnquiryId={}, fetching all enquiries",
										groupEnquiryId);

								// Fetch all enquiries under this group
								String groupUrl = lmsUrl + "/api/v1/accommodationEnquiry/group/" + groupEnquiryId;
								ResponseEntity<AccommodationEnquiryDto[]> groupResponse = restTemplate
										.getForEntity(groupUrl, AccommodationEnquiryDto[].class);

								AccommodationEnquiryDto[] groupEnquiries = groupResponse.getBody();
								logger.info("🔹 Fetched {} enquiries for groupEnquiryId={}", 
							            groupEnquiries != null ? groupEnquiries.length : 0, groupEnquiryId);

								if (groupEnquiries != null) {
									for (AccommodationEnquiryDto groupEnquiry : groupEnquiries) {
										 if (groupEnquiry.getAdvanceAmount() != null && groupEnquiry.getTotalAmount() != null) {
							                    if (groupEnquiry.getAdvanceAmount().compareTo(groupEnquiry.getTotalAmount()) == 0) {
							                        groupEnquiry.setPaymentStatus(PaymentStatus.Paid);
							                    } else if (groupEnquiry.getAdvanceAmount().compareTo(BigDecimal.ZERO) > 0 &&
							                               groupEnquiry.getAdvanceAmount().compareTo(groupEnquiry.getTotalAmount()) < 0) {
							                        groupEnquiry.setPaymentStatus(PaymentStatus.PartiallyPaid);
							                    } else {
							                        groupEnquiry.setPaymentStatus(PaymentStatus.NotPaid);
							                    }
							                }
										restTemplate.postForEntity(lmsUrl + "/api/v1/accommodationEnquiry",
												groupEnquiry, AccommodationEnquiryDto.class);

										logger.info(
												"✅ Payment status updated to Paid for enquiryId={} (groupEnquiryId={})",
												groupEnquiry.getEnquiryId(), groupEnquiryId);
									}
								}
							} else {
								if ("Pay Later".equalsIgnoreCase(enquiry.getEnquiryType())) {
								    enquiry.setPaymentStatus(PaymentStatus.NotPaid);

								} else if (enquiry.getAdvanceAmount().compareTo(enquiry.getTotalAmount()) == 0) {
								    enquiry.setPaymentStatus(PaymentStatus.Paid);

								} else if (enquiry.getAdvanceAmount().compareTo(BigDecimal.ZERO) > 0
								        && enquiry.getAdvanceAmount().compareTo(enquiry.getTotalAmount()) < 0) {
								    enquiry.setPaymentStatus(PaymentStatus.PartiallyPaid);

								} else {
								    enquiry.setPaymentStatus(PaymentStatus.NotPaid);
								}

								

								restTemplate.postForEntity(lmsUrl + "/api/v1/accommodationEnquiry", enquiry,
										AccommodationEnquiryDto.class);

								logger.info("✅ Enquiry payment status updated to Paid for enquiryId={}", enquiryId);
							}
						}
					} catch (Exception ex) {
						logger.error("❌ Failed to update enquiry payment status for enquiryId={}", enquiryId, ex);
					}
				}

			}

			else if ("payment_link.paid".equals(event) || "payment_link.partially_paid".equals(event)) {
				JSONObject paymentLink = json.getJSONObject("payload").getJSONObject("payment_link")
						.getJSONObject("entity");
				String description = paymentLink.optString("description");
				logger.info("🧾 Description from payment_link entity: {}", description);

				if (description == null || !description.contains("enquiryId") || !description.contains("propertyId")) {
					logger.warn("Invalid or missing description: {}", description);
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing or invalid description format");
				}

				Map<String, String> parsedMap = Arrays.stream(description.split("&")).map(entry -> entry.split("="))
						.filter(pair -> pair.length == 2).collect(Collectors.toMap(pair -> pair[0], pair -> pair[1]));

				Long enquiryId = Long.parseLong(parsedMap.get("enquiryId"));
				Long propertyId = Long.parseLong(parsedMap.get("propertyId"));

				logger.info("Extracted enquiryId={}, propertyId={}", enquiryId, propertyId);

				PropertyDto property = externalAPIService.findById(propertyId);
				if (property == null || property.getPaymentGatewayApiKey() == null
						|| property.getPaymentGatewayPublicKey() == null
						|| property.getPaymentGatewayCallbackUrl() == null) {
					logger.error("Razorpay credentials or callback secret missing for propertyId: {}", propertyId);
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Missing Razorpay credentials or callback secret");
				}
				String propertyMobile = property.getMobile();

				// ✅ Use callbackUrl as the secret for verifying the signature
				if (!verifySignature(payload, signature, property.getPaymentGatewayCallbackUrl())) {
					logger.error("Invalid webhook signature using callbackUrl for propertyId={}", propertyId);
					return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid signature");
				}

				RazorpayClient razorpayClient = new RazorpayClient(property.getPaymentGatewayApiKey(),
						property.getPaymentGatewayPublicKey());

				String razorpayOrderId = paymentLink.optString("order_id", null);
				logger.info("Order ID from payment entity: {}", razorpayOrderId);

				BigDecimal paidAmount = BigDecimal.ZERO;
				if (razorpayOrderId != null) {
					Order order = razorpayClient.orders.fetch(razorpayOrderId);
					logger.info("Order fetched from Razorpay: {}", order);
					int amountPaidInPaise = order.get("amount_paid");
					paidAmount = new BigDecimal(amountPaidInPaise).divide(BigDecimal.valueOf(100));
				}

				BookingDto booking = fetchBookingById(enquiryId);
				if (booking != null && BookingStatus.ENQUIRY.equals(booking.getBookingStatus())) {
					booking.setBookingStatus(BookingStatus.CONFIRMED);
					BookingDto updatedBooking = saveBooking(booking);
					logger.info("Booking updated to CONFIRMED: {}", updatedBooking);

					JSONObject payment = json.getJSONObject("payload").getJSONObject("payment").getJSONObject("entity");
//
//	                int amountPaise = payment.getInt("amount"); // in paise
//	                int feePaise = payment.optInt("fee", 0);     // in paise, default to 0 if missing
//
//	                BigDecimal amount = BigDecimal.valueOf(amountPaise).divide(BigDecimal.valueOf(100));
//	                BigDecimal fee = BigDecimal.valueOf(feePaise).divide(BigDecimal.valueOf(100));
//	                BigDecimal actualReceived = amount.subtract(fee);
					int amountPaise = payment.getInt("amount"); // in paise
					int feePaise = payment.optInt("fee", 0); // in paise
					String feeBearer = payment.optString("fee_bearer", "platform"); // default to platform

					BigDecimal amount = BigDecimal.valueOf(amountPaise).divide(BigDecimal.valueOf(100));
					BigDecimal fee = BigDecimal.valueOf(feePaise).divide(BigDecimal.valueOf(100));

					BigDecimal actualReceived;
					if ("customer".equalsIgnoreCase(feeBearer)) {
						actualReceived = amount.subtract(fee);
					} else {
						actualReceived = amount;
					}

					String paymentType = payment.optString("method");

					PaymentDto paymentDto = new PaymentDto();
					paymentDto.setStatus(PaymentStatus.Paid);
					paymentDto.setTransactionAmount(actualReceived);
					paymentDto.setPaymentMode(PaymentMode.Razorpay);
					/*
					 * if ("NETBANKING".equalsIgnoreCase(paymentType)) {
					 * paymentDto.setPaymentMode(PaymentMode.BankTransfer); } else if
					 * ("CARD".equalsIgnoreCase(paymentType)) {
					 * paymentDto.setPaymentMode(PaymentMode.Credit); } else if
					 * ("UPI".equalsIgnoreCase(paymentType)) {
					 * paymentDto.setPaymentMode(PaymentMode.UPI); }
					 */
					if (updatedBooking.getPropertyReservationNumber() != null) {
						paymentDto.setReferenceNumber(updatedBooking.getPropertyReservationNumber());
					}

					paymentDto.setAdvancePayment(true);
					paymentDto.setPropertyId(updatedBooking.getPropertyId());
					paymentDto.setCustomerName(updatedBooking.getFirstName() + " " + updatedBooking.getLastName());
					paymentDto.setEmail(updatedBooking.getEmail());
					paymentDto.setDate(new java.sql.Date(new Date().getTime()));
					paymentDto.setBusinessServiceName("Accommodation");

					logger.info("Saving Payment: {}", paymentDto);
					ResponseEntity<PaymentDto> response = restTemplate
							.postForEntity(bookoneUrl + "/api/website/savePayment", paymentDto, PaymentDto.class);
					logger.info("Payment saved: {}", response.getBody());

					String referenceNumber = updatedBooking.getPropertyReservationNumber();
					String findPaymentUrl = bookoneUrl + "/api/website/findPaymentByReferenceNumber/" + referenceNumber;
					logger.info("Step 2: Fetching payment by referenceNumber: {}", referenceNumber);

					ResponseEntity<PaymentDto[]> responsepayment = restTemplate.getForEntity(findPaymentUrl,
							PaymentDto[].class);
					PaymentDto[] payments = responsepayment.getBody();
					if (payments != null && payments.length > 0) {
						logger.info("Fetched payment: {}", payments[0]);
					}

					BookingDto bookingAfterPayment = fetchBookingById(enquiryId);
					logger.info("Step 3: Updating booking after setTotalPaymentAmountpayment: {}", actualReceived);				
					bookingAfterPayment.setTotalPaymentAmount(actualReceived);
					bookingAfterPayment.setNotes("Booking converted from mannual enquiry");
					bookingAfterPayment.setModeOfPayment("Razorpay");
					restTemplate.postForEntity(bookoneUrl + "/api/website/booking", bookingAfterPayment,
							BookingDto.class);
					logger.info("Step 3: Updating booking after payment: {}",
							new ObjectMapper().writeValueAsString(bookingAfterPayment));
					Thread.sleep(1500);

					try {
						String voucherGenerateUrl = bookoneUrl + "/api/website/generateBookingVoucher?bookingId="
								+ enquiryId;
						logger.info("Voucher generation URL: {}", voucherGenerateUrl);
						restTemplate.getForEntity(voucherGenerateUrl, Void.class);

						BookingDto updatedVoucherBooking = null;
						String voucherUrl = null;
						int retry = 0;
						while (retry++ < 5) {
							Thread.sleep(1000);
							updatedVoucherBooking = fetchBookingById(enquiryId);
							voucherUrl = updatedVoucherBooking.getVoucherUrl();
							if (voucherUrl != null && !voucherUrl.isEmpty())
								break;
						}

						if (voucherUrl != null && !voucherUrl.isEmpty()) {
							logger.info("Voucher URL ready for enquiryId={}: {}", enquiryId, voucherUrl);
							WhatsappDto whatsappDto = buildWhatsappTemplate(updatedVoucherBooking, actualReceived,
									voucherUrl, propertyMobile);
							logger.info("Sending WhatsAppDto to {}: {}", whatsappSendUrl,
									new ObjectMapper().writeValueAsString(whatsappDto));
							ResponseEntity<String> whatsappResponse = restTemplate.postForEntity(whatsappSendUrl,
									whatsappDto, String.class);
							logger.info("WhatsApp message sent. Response: {}", whatsappResponse.getBody());
						} else {
							logger.warn("Voucher URL not ready even after retries. Skipping WhatsApp for enquiryId={}",
									enquiryId);
						}

					} catch (Exception e) {
						logger.error(
								"Exception while generating voucher or sending WhatsApp for enquiryId=" + enquiryId, e);
					}

				} else {
					logger.warn("Booking already confirmed or not found for enquiryId: {}", enquiryId);
				}
			}

			return ResponseEntity.ok("Webhook handled successfully");

		} catch (Exception e) {
			logger.error("❗ Webhook processing failed", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Webhook error");
		}
	}

	private BookingDto fetchBookingById(Long bookingId) {
		ResponseEntity<BookingDto> response = restTemplate
				.getForEntity(bookoneUrl + "/api/website/findBookingById?BookingId=" + bookingId, BookingDto.class);
		return response.getBody();
	}

	private BookingDto saveBooking(BookingDto bookingDto) {
		ResponseEntity<BookingDto> response = restTemplate.postForEntity(bookoneUrl + "/api/website/booking",
				bookingDto, BookingDto.class);
		return response.getBody();
	}

	public WhatsappDto buildWhatsappTemplate(BookingDto booking, BigDecimal paidAmount, String voucherUrl,
			String propertyMobile) {

		WhatsappDto whatsappDto = new WhatsappDto();
		whatsappDto.setMessaging_product("whatsapp");
		whatsappDto.setRecipient_type("individual");
		whatsappDto.setTo(booking.getMobile().replace("+91", "")); // send to mobile without +91
		whatsappDto.setType("template");

		// Template
		WhatsappDto.Template template = new WhatsappDto.Template();
		template.setName("booking_confirmation_voucher"); // Template name as per your JSON
		WhatsappDto.Language language = new WhatsappDto.Language();
		language.setCode("en");
		template.setLanguage(language);

		List<WhatsappDto.Components> components = new ArrayList<>();

		// ✅ HEADER - Document PDF
		WhatsappDto.Components header = new WhatsappDto.Components();
		header.setType("header");

		WhatsappDto.Components.Parameters documentParam = new WhatsappDto.Components.Parameters();
		documentParam.setType("document");

		WhatsappDto.Components.Document document = new WhatsappDto.Components.Document();
		document.setLink(voucherUrl);
		String filename = voucherUrl.substring(voucherUrl.lastIndexOf("/") + 1);
		document.setFilename(filename);

		documentParam.setDocument(document);
		header.setParameters(Collections.singletonList(documentParam));
		components.add(header);

		// ✅ BODY - Parameters in order
		WhatsappDto.Components body = new WhatsappDto.Components();
		body.setType("body");

		List<WhatsappDto.Components.Parameters> bodyParams = new ArrayList<>();
		bodyParams.add(createTextParam(booking.getFirstName()));
		bodyParams.add(createTextParam(booking.getBusinessName()));
		bodyParams.add(createTextParam(booking.getPropertyReservationNumber()));
		bodyParams.add(createTextParam(formatDate(booking.getFromDate())));
		bodyParams.add(createTextParam(formatAmount(paidAmount)));
		bodyParams.add(createTextParam(propertyMobile.replace("+91", "")));

		body.setParameters(bodyParams);
		components.add(body);

		// Set components to template
		template.setComponents(components);
		whatsappDto.setTemplate(template);

		return whatsappDto;
	}

	private WhatsappDto.Components.Parameters createTextParam(String value) {
		WhatsappDto.Components.Parameters param = new WhatsappDto.Components.Parameters();
		param.setType("text");
		param.setText(value);
		return param;
	}

	private String formatDate(Date date) {
		if (date == null)
			return "";
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}

	private String formatAmount(BigDecimal amount) {
		if (amount == null)
			return "0";
		DecimalFormat formatter = new DecimalFormat("#,##0");
		return formatter.format(amount);
	}

	private boolean verifySignature(String payload, String actualSignature, String secret) throws Exception {
		String generated = hmacSHA256(payload, secret);
		logger.info("🔐 Razorpay Signature Header: {}", actualSignature);
		logger.info("🧮 Generated HMAC Signature: {}", generated);
		return generated.equals(actualSignature);
	}

	private String hmacSHA256(String data, String secret) throws Exception {
		SecretKeySpec key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(key);
		byte[] hashBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
		return Hex.encodeHexString(hashBytes);
	}

	@PostMapping("/hotelmate/createPaymentLink")
	public ResponseEntity<?> hotelmateCreatePaymentLink(@RequestBody RazorpayPaymentLinkRequest request,
			@RequestParam Long propertyId) {
		try {
			PropertyDto property = externalAPIService.findHotelMatePropertyById(propertyId);
			RazorpayPaymentLinkResponseDto response = paymentGatewayService.createrazorpayPaymentLink(property,
					request);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

	@PostMapping("/bookone/createPaymentLink")
	public ResponseEntity<?> bookoneCreatePaymentLink(@RequestBody RazorpayPaymentLinkRequest request,
			@RequestParam Long propertyId) {
		try {
			PropertyDto property = externalAPIService.findById(propertyId);
			RazorpayPaymentLinkResponseDto response = paymentGatewayService.createrazorpayPaymentLink(property,
					request);
			return ResponseEntity.ok(response);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	/*
	 * @PostMapping("/createPaymentLink") public ResponseEntity<?>
	 * createPaymentLink(@RequestBody PaymentDto paymentDto) { try {
	 * RazorpayPaymentLinkResponseDto response =
	 * paymentGatewayService.createPaymentLink(paymentDto); return
	 * ResponseEntity.ok(response); } catch (Exception e) { // Log the full error
	 * for debugging Logger logger = LoggerFactory.getLogger(this.getClass());
	 * logger.error("Error while creating Razorpay Payment Link", e);
	 * 
	 * // Return structured error response Map<String, Object> error = new
	 * HashMap<>(); error.put("message", "Failed to create Razorpay Payment Link");
	 * error.put("error", e.getMessage()); return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error); } }
	 * 
	 * @PostMapping("/hotelmate/createPaymentLink") public ResponseEntity<?>
	 * hotelmateCreatePaymentLink(@RequestBody PaymentDto paymentDto,
	 * 
	 * @RequestParam Long propertyId) { try { PropertyDto property =
	 * externalAPIService.findHotelMatePropertyById(propertyId);
	 * RazorpayPaymentLinkResponseDto response =
	 * paymentGatewayService.createPaymentLink(property, paymentDto); return
	 * ResponseEntity.ok(response); } catch (Exception ex) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage())
	 * ; } }
	 * 
	 * // BOOKONE endpoint
	 * 
	 * @PostMapping("/bookone/createPaymentLink") public ResponseEntity<?>
	 * bookoneCreatePaymentLink(@RequestBody PaymentDto paymentDto,
	 * 
	 * @RequestParam Long propertyId) { try { PropertyDto property =
	 * externalAPIService.findById(propertyId); RazorpayPaymentLinkResponseDto
	 * response = paymentGatewayService.createPaymentLink(property, paymentDto);
	 * return ResponseEntity.ok(response); } catch (Exception ex) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage())
	 * ; } }
	 */
}
