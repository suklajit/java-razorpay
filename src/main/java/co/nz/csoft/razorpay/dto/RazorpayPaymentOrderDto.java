package co.nz.csoft.razorpay.dto;

import java.util.List;

public class RazorpayPaymentOrderDto {

	
	    private String orderId;
	    private String entity;
	    private int amount;
	    private int amount_paid;
	    private int amount_due;
	    private String currency;
	    private String receipt;
	    private String status;
	    private int attempts;
	    private List<OrderNotesDto> notes;
	    private int created_at;
	    
	    
	    
		public String getOrderId() {
			return orderId;
		}
		public String getEntity() {
			return entity;
		}
		public int getAmount() {
			return amount;
		}
		public int getAmount_paid() {
			return amount_paid;
		}
		public int getAmount_due() {
			return amount_due;
		}
		public String getCurrency() {
			return currency;
		}
		public String getReceipt() {
			return receipt;
		}
		public String getStatus() {
			return status;
		}
		public int getAttempts() {
			return attempts;
		}
		
		public List<OrderNotesDto> getNotes() {
			return notes;
		}
		
		public int getCreated_at() {
			return created_at;
		}
		public void setId(String orderId) {
			this.orderId = orderId;
		}
		public void setEntity(String entity) {
			this.entity = entity;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public void setAmount_paid(int amount_paid) {
			this.amount_paid = amount_paid;
		}
		public void setAmount_due(int amount_due) {
			this.amount_due = amount_due;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public void setReceipt(String receipt) {
			this.receipt = receipt;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public void setAttempts(int attempts) {
			this.attempts = attempts;
		}
		public void setNotes(List<OrderNotesDto> notes) {
			this.notes = notes;
		}
		public void setCreated_at(int created_at) {
			this.created_at = created_at;
		}
		
		
		
		@Override
		public String toString() {
			return "RazorpayPaymentOrderDto [id=" + orderId + ", entity=" + entity + ", amount=" + amount + ", amount_paid="
					+ amount_paid + ", amount_due=" + amount_due + ", currency=" + currency + ", receipt=" + receipt
					+ ", status=" + status + ", attempts=" + attempts + ", notes=" + notes + ", created_at="
					+ created_at + "]";
		}
	    
	   
	    
	    
	    
}
