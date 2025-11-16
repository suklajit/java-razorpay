package co.nz.csoft.razorpay.serviceImpl;

import co.nz.csoft.razorpay.dto.PaymentReceiveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.nz.csoft.razorpay.dto.ErrorObject;
import co.nz.csoft.razorpay.dto.PropertyDto;
import co.nz.csoft.razorpay.service.ExternalAPIService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ExternalAPIServiceImpl implements ExternalAPIService {
	
	@Value("${bookone.API.url}")
	private String bookoneUrl;
	
	@Value("${hotelmate.API.url}")
	private String hotelmateUrl;

	@Value("${subscription.api-url}")
	private String subscriptionBaseUrl;
	
	private static final Logger log = LoggerFactory.getLogger(ExternalAPIServiceImpl.class);
	
	RestTemplate restTemplate = new RestTemplate();
	
	ObjectMapper objMapper = new ObjectMapper();

	@Override
	public PropertyDto findById(Long propertyId) {
		ResponseEntity<PropertyDto> resp = restTemplate.getForEntity(bookoneUrl
				+ "/api/website/findByPropertyId/"+propertyId,
				PropertyDto.class);
		PropertyDto propertyDto = resp.getBody();
		return propertyDto;
		
	}
	
	@Override
	public PropertyDto findHotelMatePropertyById(Long propertyId) {
		ResponseEntity<PropertyDto> resp = restTemplate.getForEntity(hotelmateUrl
				+ "/api/thm/findByPropertyId/"+propertyId,
				PropertyDto.class);
		PropertyDto propertyDto = resp.getBody();
		return propertyDto;
	}
	
	//send error to queue
	@Override
	public void sendToErrorQueue(ErrorObject errorObject) {
		log.info("******Sending Error Message to Q_Error_Reservations.....*****");
        try {
			log.info("******Message....*****:" + objMapper.writeValueAsString(errorObject));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        restTemplate.postForObject(
        		bookoneUrl + "/api/website/errorObj", errorObject,
				Void.class);
        log.info("******Sending Error Message to Q_Error_Reservations - DONE*****");
	}

	@Override
	public void sendSubscriptionPaymentWebhook(String invoiceId,
											   BigDecimal paidAmount,
											   boolean paymentFailed,
											   boolean partialPaid) {

		String SUBSCRIPTION_WEBHOOK_URL = subscriptionBaseUrl + "/api/subscriptions/payment";
		PaymentReceiveDto dto = new PaymentReceiveDto();
		dto.setInvoiceId(invoiceId);
		dto.setPricePaid(paidAmount != null ? paidAmount : BigDecimal.ZERO);
		dto.setPaymentFailed(paymentFailed);
		dto.setPartialPaid(partialPaid);

		dto.setPartialPaid(!paymentFailed && paidAmount.compareTo(BigDecimal.ZERO) > 0);

		log.info("Sending Subscription webhook → {} | Payload = {}", SUBSCRIPTION_WEBHOOK_URL, dto);

		try {
			restTemplate.postForEntity(SUBSCRIPTION_WEBHOOK_URL, dto, Void.class);
			log.info("Subscription webhook sent successfully for invoiceId={}", invoiceId);
		} catch (Exception ex) {
			log.error("Failed to send subscription webhook for invoiceId={}", invoiceId, ex);
		}
	}

}
