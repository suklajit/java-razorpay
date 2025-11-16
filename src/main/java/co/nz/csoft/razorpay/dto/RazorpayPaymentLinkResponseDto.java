package co.nz.csoft.razorpay.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RazorpayPaymentLinkResponseDto {

    private boolean accept_partial;
    private long amount;
    private long amount_paid;
    private String callback_method;
    private String callback_url;
    private long cancelled_at;
    private long created_at;
    private String currency;
    private Customer customer;
    private String description;
    private long expire_by;
    private long expired_at;
    private long first_min_partial_amount;
    private String id;
    private Notes notes;
    private Notify notify;
    private Object payments;
    private String reference_id;
    private boolean reminder_enable;
    private List<Object> reminders;
    private String short_url;
    private String status;
    private long updated_at;
    private String user_id;
    

    public boolean isAccept_partial() {
		return accept_partial;
	}

	public void setAccept_partial(boolean accept_partial) {
		this.accept_partial = accept_partial;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(long amount_paid) {
		this.amount_paid = amount_paid;
	}

	public String getCallback_method() {
		return callback_method;
	}

	public void setCallback_method(String callback_method) {
		this.callback_method = callback_method;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public long getCancelled_at() {
		return cancelled_at;
	}

	public void setCancelled_at(long cancelled_at) {
		this.cancelled_at = cancelled_at;
	}

	public long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(long created_at) {
		this.created_at = created_at;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getExpire_by() {
		return expire_by;
	}

	public void setExpire_by(long expire_by) {
		this.expire_by = expire_by;
	}

	public long getExpired_at() {
		return expired_at;
	}

	public void setExpired_at(long expired_at) {
		this.expired_at = expired_at;
	}

	public long getFirst_min_partial_amount() {
		return first_min_partial_amount;
	}

	public void setFirst_min_partial_amount(long first_min_partial_amount) {
		this.first_min_partial_amount = first_min_partial_amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public Notify getNotify() {
		return notify;
	}

	public void setNotify(Notify notify) {
		this.notify = notify;
	}

	public Object getPayments() {
		return payments;
	}

	public void setPayments(Object payments) {
		this.payments = payments;
	}

	public String getReference_id() {
		return reference_id;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public boolean isReminder_enable() {
		return reminder_enable;
	}

	public void setReminder_enable(boolean reminder_enable) {
		this.reminder_enable = reminder_enable;
	}

	public List<Object> getReminders() {
		return reminders;
	}

	public void setReminders(List<Object> reminders) {
		this.reminders = reminders;
	}

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(long updated_at) {
		this.updated_at = updated_at;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public static class Customer {
        private String contact;
        private String email;
        private String name;
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

       
    }

    public static class Notes {
        private String policy_name;

		public String getPolicy_name() {
			return policy_name;
		}

		public void setPolicy_name(String policy_name) {
			this.policy_name = policy_name;
		}

       
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Notify {
        private boolean email;
        private boolean sms;
		public boolean isEmail() {
			return email;
		}
		public void setEmail(boolean email) {
			this.email = email;
		}
		public boolean isSms() {
			return sms;
		}
		public void setSms(boolean sms) {
			this.sms = sms;
		}

      
    }


}
