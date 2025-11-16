package co.nz.csoft.razorpay.service;

import com.stripe.exception.StripeException;

import co.nz.csoft.razorpay.dto.PaymentDto;
import co.nz.csoft.razorpay.dto.PropertyDto;
import co.nz.csoft.razorpay.dto.RazorpayPaymentLinkRequest;
import co.nz.csoft.razorpay.dto.RazorpayPaymentLinkResponseDto;
import co.nz.csoft.razorpay.dto.RefundDto;

import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author dylan
 */
public interface PaymentGatewayService {

	// PaymentDto chargeCard(PropertyDto property, PaymentDto paymentDto) throws
	// StripeException, IOException;
	PaymentDto paymentIntent(PropertyDto property, PaymentDto paymentDto)
			throws StripeException, IOException, Exception;

	RefundDto refundPayment(PropertyDto property, RefundDto refundDto) throws Exception;

	//RazorpayPaymentLinkResponseDto createPaymentLink(PropertyDto property, PaymentDto paymentDto) throws Exception;

	RazorpayPaymentLinkResponseDto createrazorpayPaymentLink(PropertyDto property, RazorpayPaymentLinkRequest request)
			throws Exception;



}
