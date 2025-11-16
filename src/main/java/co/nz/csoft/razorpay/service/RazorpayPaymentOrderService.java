package co.nz.csoft.razorpay.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayException;

import co.nz.csoft.razorpay.dto.RazorpayPaymentOrderDto;



@Service
public interface RazorpayPaymentOrderService {

	String createOrder(RazorpayPaymentOrderDto paymentDto) throws Exception;

	String fetchByOrderId(String orderId) throws RazorpayException;

	String fetchAllOrders() throws RazorpayException;

	String fetchPaymentsOfAnOrder(String orderId) throws RazorpayException;


	
}
