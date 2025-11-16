package co.nz.csoft.razorpay.serviceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.Value;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.stripe.exception.StripeException;

import co.nz.csoft.razorpay.dto.PaymentDto;
import co.nz.csoft.razorpay.dto.PropertyDto;
import co.nz.csoft.razorpay.dto.RazorpayPaymentLinkRequest;
import co.nz.csoft.razorpay.dto.RazorpayPaymentLinkResponseDto;
import co.nz.csoft.razorpay.dto.RefundDto;
import co.nz.csoft.razorpay.service.PaymentGatewayService;



@Service("razorpay_paymentgw")
public class RazorpayPaymentGatewayServiceImpl implements PaymentGatewayService{

	Logger logger = LoggerFactory.getLogger(RazorpayPaymentGatewayServiceImpl.class);

	
	@Override
	public PaymentDto paymentIntent(PropertyDto property, PaymentDto paymentDto)
			throws StripeException, IOException, Exception {
		
		
		String key_ID = property.getPaymentGatewayApiKey();
		String key_SECRET = property.getPaymentGatewayPublicKey();

		BigDecimal amount = paymentDto.getTransactionAmount();
		String currency = paymentDto.getCurrency();
		String receipt = paymentDto.getReceiptNumber();
		Long enquiryId = paymentDto.getOrderId();
		
		RazorpayClient razorpayClient = new RazorpayClient(key_ID, key_SECRET);
		
		logger.info("Connection created.......!@" +amount);
		long amountInPaise = amount.multiply(new BigDecimal("100")).longValue();
		JSONObject notes = new JSONObject();
	    notes.put("enquiryId", enquiryId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("currency", currency);
		jsonObject.put("amount", amountInPaise);
		jsonObject.put("receipt", receipt);
		jsonObject.put("notes", notes); 
		System.out.println("amount : "+jsonObject.toString());
		Order order = razorpayClient.orders.create(jsonObject);
		logger.info("Order created.......!@ "+ order);
		String razorpayOrderId = order.get("id").toString();
		
		logger.info("Getting Oreder Id......!@ "+ razorpayOrderId);
		
		if (razorpayOrderId == null) {
			
			
		}else {
			paymentDto.setRazorpayOrderId(razorpayOrderId);
		}
		
		
		return paymentDto;
	}
	
	
	@Override
	public RefundDto refundPayment(PropertyDto property, RefundDto refundDto) throws Exception {
	    Logger logger = LoggerFactory.getLogger(RazorpayPaymentGatewayServiceImpl.class);

	    String key_ID = property.getPaymentGatewayApiKey();
	    String key_SECRET = property.getPaymentGatewayPublicKey();

	    RazorpayClient razorpayClient = new RazorpayClient(key_ID, key_SECRET);
	    JSONObject refundRequest = new JSONObject();

	    // 🔁 Fetch paymentId if not provided
	    String paymentId = refundDto.getPaymentId();
	    if (paymentId == null || paymentId.isEmpty()) {
	        if (refundDto.getRazorpayOrderId() != null) {
	            paymentId = fetchPaymentIdFromOrderId(razorpayClient, refundDto.getRazorpayOrderId());
	        } else {
	            throw new IllegalArgumentException("Either paymentId or razorpayOrderId must be provided");
	        }
	    }

	    refundRequest.put("payment_id", paymentId);

	    if (refundDto.getRefundAmount() != null) {
	        long amountInPaise = refundDto.getRefundAmount().multiply(new BigDecimal("100")).longValue();
	        refundRequest.put("amount", amountInPaise);
	    }

	    if (refundDto.getReason() != null) {
	        JSONObject notes = new JSONObject();
	        notes.put("reason", refundDto.getReason());
	        refundRequest.put("notes", notes);
	    }

	    logger.info("Creating refund for paymentId: {}", paymentId);

	    Refund refund = razorpayClient.refunds.create(refundRequest);

	    logger.info("Refund created: {}", refund.toString());

	    // Build refund response DTO
	    RefundDto response = new RefundDto();
	    response.setPaymentId(refund.get("payment_id"));
	    response.setRazorpayRefundId(refund.get("id"));
	    response.setStatus(refund.get("status"));
	    response.setRefundAmount(refundDto.getRefundAmount());
	    response.setReason(refundDto.getReason());

	    return response;
	}

	private String fetchPaymentIdFromOrderId(RazorpayClient razorpayClient, String razorpayOrderId) throws RazorpayException {
	    List<Payment> payments = razorpayClient.orders.fetchPayments(razorpayOrderId);
	    if (payments != null && !payments.isEmpty()) {
	        return payments.get(0).get("id"); 
	    } else {
	        throw new RuntimeException("No payment found for order ID: " + razorpayOrderId);
	    }
	}

	
	/*
	@Override
	public RazorpayPaymentLinkResponseDto createPaymentLink(PropertyDto property, PaymentDto paymentDto) throws Exception {

	    String key_ID = property.getPaymentGatewayApiKey();
	    String key_SECRET = property.getPaymentGatewayPublicKey();

	    RazorpayClient razorpayClient = new RazorpayClient(key_ID, key_SECRET);

	    RazorpayPaymentLinkRequest request = new RazorpayPaymentLinkRequest();
	    request.setAmount(paymentDto.getTransactionAmount().multiply(new BigDecimal(100)).longValue());
	    request.setCurrency(paymentDto.getCurrency());
	    request.setAccept_partial(true);
	    request.setFirst_min_partial_amount(100);
	    request.setReference_id(paymentDto.getReceiptNumber());
	    request.setDescription(paymentDto.getDescription());
	    request.setReminder_enable(true);
	    request.setCallback_url("https://example-callback-url.com/");
	    request.setCallback_method("get");

	    RazorpayPaymentLinkRequest.Customer customer = new RazorpayPaymentLinkRequest.Customer();
	    customer.setName(paymentDto.getCustomerName());
	    //customer.setContact(paymentDto.getCustomerContact());
	    //customer.setEmail(paymentDto.getCustomerEmail());
	    request.setCustomer(customer);

	    RazorpayPaymentLinkRequest.Notify notify = new RazorpayPaymentLinkRequest.Notify();
	    notify.setSms(true);
	    notify.setEmail(true);
	    request.setNotify(notify);

	    RazorpayPaymentLinkRequest.Notes notes = new RazorpayPaymentLinkRequest.Notes();
	    //notes.setPolicy_name(paymentDto.getPolicyName());
	    request.setNotes(notes);

	    // Convert to JSON using Jackson
	    ObjectMapper objectMapper = new ObjectMapper();
	    String json = objectMapper.writeValueAsString(request);
	    JSONObject jsonObject = new JSONObject(json);

	    logger.info("Creating Razorpay Payment Link with: {}", jsonObject.toString());

	    PaymentLink paymentLink = razorpayClient.paymentLink.create(jsonObject);

	    logger.info("Payment Link created: {}", paymentLink);

	    // Convert Razorpay response JSON to DTO
	    RazorpayPaymentLinkResponseDto responseDto =
	            objectMapper.readValue(paymentLink.toString(), RazorpayPaymentLinkResponseDto.class);

	    return responseDto;
	}
*/
	@Override
	public RazorpayPaymentLinkResponseDto createrazorpayPaymentLink(PropertyDto property, RazorpayPaymentLinkRequest request) throws Exception {
	    String key_ID = property.getPaymentGatewayApiKey();
	    String key_SECRET = property.getPaymentGatewayPublicKey();
	    System.out.println("property.getPaymentGatewayApiKey() :"+ property.getPaymentGatewayApiKey() );
System.out.println("property.getPaymentGatewayPublicKey(); :"+ property.getPaymentGatewayPublicKey());
	    RazorpayClient razorpayClient = new RazorpayClient(key_ID, key_SECRET);

	    // Convert RazorpayPaymentLinkRequest to JSONObject
	    ObjectMapper objectMapper = new ObjectMapper();
	    String json = objectMapper.writeValueAsString(request);
	    JSONObject jsonObject = new JSONObject(json);

	    // Create Payment Link
	    PaymentLink paymentLink = razorpayClient.paymentLink.create(jsonObject);
	    System.out.println("Razorpay Payment Link Response: " + paymentLink.toString());

	    // Convert to response DTO
	    return objectMapper.readValue(paymentLink.toString(), RazorpayPaymentLinkResponseDto.class);
	}



	
	
}
