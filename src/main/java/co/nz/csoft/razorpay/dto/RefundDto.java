package co.nz.csoft.razorpay.dto;

import java.math.BigDecimal;

public class RefundDto {
    private String paymentId;
    private String razorpayRefundId;
    private BigDecimal refundAmount; 
    private String reason;
    private String status;
    private String razorpayOrderId;
    
    
	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getRazorpayRefundId() {
		return razorpayRefundId;
	}
	public void setRazorpayRefundId(String razorpayRefundId) {
		this.razorpayRefundId = razorpayRefundId;
	}
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
    

}
