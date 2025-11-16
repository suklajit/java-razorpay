package co.nz.csoft.razorpay.dto;

public class RazorpayPaymentLinkRequest {

    private long amount;
    private String currency;
    private boolean accept_partial;
    private long first_min_partial_amount;
    private long expire_by;
    private String reference_id;
    private String description;
    private Customer customer;
    private Notify notify;
    private boolean reminder_enable;
    private Notes notes;
    private String callback_url;
    private String callback_method;

   

    public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isAccept_partial() {
		return accept_partial;
	}

	public void setAccept_partial(boolean accept_partial) {
		this.accept_partial = accept_partial;
	}

	public long getFirst_min_partial_amount() {
		return first_min_partial_amount;
	}

	public void setFirst_min_partial_amount(long first_min_partial_amount) {
		this.first_min_partial_amount = first_min_partial_amount;
	}

	public long getExpire_by() {
		return expire_by;
	}

	public void setExpire_by(long expire_by) {
		this.expire_by = expire_by;
	}

	public String getReference_id() {
		return reference_id;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Notify getNotify() {
		return notify;
	}

	public void setNotify(Notify notify) {
		this.notify = notify;
	}

	public boolean isReminder_enable() {
		return reminder_enable;
	}

	public void setReminder_enable(boolean reminder_enable) {
		this.reminder_enable = reminder_enable;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

	public String getCallback_method() {
		return callback_method;
	}

	public void setCallback_method(String callback_method) {
		this.callback_method = callback_method;
	}

	public static class Customer {
        private String name;
        private String contact;
        private String email;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
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

        
    }

    public static class Notify {
        private boolean sms;
        private boolean email;
		public boolean isSms() {
			return sms;
		}
		public void setSms(boolean sms) {
			this.sms = sms;
		}
		public boolean isEmail() {
			return email;
		}
		public void setEmail(boolean email) {
			this.email = email;
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

    // Getters and Setters for all fields
    // You can use Lombok for brevity: @Getter, @Setter
}

