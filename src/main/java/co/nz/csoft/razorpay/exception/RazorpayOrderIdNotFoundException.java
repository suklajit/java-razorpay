package co.nz.csoft.razorpay.exception;

public class RazorpayOrderIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public RazorpayOrderIdNotFoundException(String msg){
		super(msg);
	}

}
