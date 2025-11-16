package co.nz.csoft.razorpay.service;


import co.nz.csoft.razorpay.dto.BookingDto;
import co.nz.csoft.razorpay.dto.ErrorObject;
import co.nz.csoft.razorpay.dto.PropertyDto;

import java.math.BigDecimal;


public interface ExternalAPIService {

	public PropertyDto findById(Long propertyId);
	
	public PropertyDto findHotelMatePropertyById(Long propertyId);

	void sendToErrorQueue(ErrorObject errorObject);

	void sendSubscriptionPaymentWebhook(String invoiceId,
										BigDecimal paidAmount,
										boolean paymentFailed,
										boolean partialPaid);
}
