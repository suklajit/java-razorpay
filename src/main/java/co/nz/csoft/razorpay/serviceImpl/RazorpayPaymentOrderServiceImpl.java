package co.nz.csoft.razorpay.serviceImpl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import co.nz.csoft.razorpay.dto.RazorpayPaymentOrderDto;
import co.nz.csoft.razorpay.exception.InvalidAmountException;
import co.nz.csoft.razorpay.exception.RazorpayOrderIdNotFoundException;
import co.nz.csoft.razorpay.service.RazorpayPaymentOrderService;

//import co.nz.csoft.exception.OrderIdNotFoundException;

@Service
public class RazorpayPaymentOrderServiceImpl implements RazorpayPaymentOrderService {

	public static final String KEY_ID = "rzp_test_HihCtbjf6LwAqU";
	public static final String KEY_SECRET = "HLyD7TVNiwvvVxiAxtdElF6J";
	public static final String currency = "INR";
	public static final String receipt = "Receipt#1234";

	@Override
	public String createOrder(RazorpayPaymentOrderDto paymentDto) throws Exception {
		int amount = paymentDto.getAmount();

		if (amount < 1) {
			throw new InvalidAmountException("The amount must be atleast INR 1.00");
		} else {

			RazorpayClient razorpayClient = new RazorpayClient(KEY_ID, KEY_SECRET);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", amount * 100);
			jsonObject.put("currency", currency);
			jsonObject.put("receipt", receipt);
			Order order = razorpayClient.orders.create(jsonObject);
			return order.toString();
		}
	}

	@Override
	public String fetchByOrderId(String orderId) {
		RazorpayClient razorpayClient;

		try {
			razorpayClient = new RazorpayClient(KEY_ID, KEY_SECRET);

			Order order = razorpayClient.orders.fetch(orderId);
			return order.toString();

		} catch (RazorpayException e) {
			throw new RazorpayOrderIdNotFoundException("The id provided does not exist");
		}

	}

	@Override
	public String fetchAllOrders() throws RazorpayException {
		RazorpayClient razorpayClient = new RazorpayClient(KEY_ID, KEY_SECRET);
		JSONObject jsonObject = new JSONObject();
		List<Order> listOforders = razorpayClient.orders.fetchAll(jsonObject);
		return listOforders.toString();
	}

	@Override
	public String fetchPaymentsOfAnOrder(String orderId) throws RazorpayException {
		RazorpayClient razorpayClient = new RazorpayClient(KEY_ID, KEY_SECRET);
		List<Payment> payments = razorpayClient.orders.fetchPayments(orderId);
		return payments.toString();
	}

}
