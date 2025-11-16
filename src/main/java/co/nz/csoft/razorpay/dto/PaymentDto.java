package co.nz.csoft.razorpay.dto;




import co.nz.csoft.razorpay.enums.PaymentMode;
import co.nz.csoft.razorpay.enums.PaymentStatus;

import java.math.BigDecimal;
import java.sql.Date;



public class PaymentDto {
	
	
    private String createdBy;
    
    private Date createdDate;
    
    private String lastModifiedBy;
    
    private Date lastModifiedDate;
    private Long id;
    private String referenceNumber;
    private String name;
    private String email;
    private String businessEmail;
    private String currency;
    private String token;
    private int expYear;
    private int expMonth;
    private String cardNumber;
    private String accountNumber;
    private String cvv;
    private String description;
    private PaymentStatus status;
    private String receiptNumber;
    private String failureMessage;
    private String failureCode;
    private String externalReference;
    private PaymentMode paymentMode;
    private BigDecimal channelCommissionAmount;
    private BigDecimal transactionChargeAmount;
    private BigDecimal otherChargesAmount;
    private BigDecimal serviceChargeAmount;
    private BigDecimal netReceivableAmount;
    private BigDecimal taxAmount;
    private String bankName;
    private String branchName;
    private String swiftCode;
    private String roomNumber;
    private BigDecimal transactionAmount;
    private Long propertyId;
    private String accountName;
    private BigDecimal bookingCommissionAmount;
    private Date date;
    private BigDecimal deliveryChargeAmount;
    private String businessServiceName;
    private String counterNumber;
    private String counterName;
    private String  operatorName;
    private String clientSecret;
    private BigDecimal convenienceFee;
    private Long serviceId;
    private String companyName ;
    private String billNo ;
    private Long orderId;
    private String propertyWebsite;
    private String callbackUrl;
    boolean isCreditSettled ;
    private Long expenseId ;
    
    private String encryptedData ;
    private String decryptedData ;
    private boolean isChargeAbleToBooking;
    
    // field from OTA bookings
    private String sourceOfBooking;
    private Integer lastFourDigitCardNumber;
    
    //payment gateway
    private String paymentGateway;
    private String customerName;
    
    
    
    //Razorpay OrderId
    private String razorpayOrderId;
    private boolean advancePayment;
    
    
    
    
    
    public boolean isAdvancePayment() {
		return advancePayment;
	}

	public void setAdvancePayment(boolean advancePayment) {
		this.advancePayment = advancePayment;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(String counterNumber) {
        this.counterNumber = counterNumber;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }



    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getChannelCommissionAmount() {
        return channelCommissionAmount;
    }

    public void setChannelCommissionAmount(BigDecimal channelCommissionAmount) {
        this.channelCommissionAmount = channelCommissionAmount;
    }

    public BigDecimal getTransactionChargeAmount() {
        return transactionChargeAmount;
    }

    public void setTransactionChargeAmount(BigDecimal transactionChargeAmount) {
        this.transactionChargeAmount = transactionChargeAmount;
    }

    public BigDecimal getOtherChargesAmount() {
        return otherChargesAmount;
    }

    public void setOtherChargesAmount(BigDecimal otherChargesAmount) {
        this.otherChargesAmount = otherChargesAmount;
    }

    public BigDecimal getNetReceivableAmount() {
        return netReceivableAmount;
    }

    public void setNetReceivableAmount(BigDecimal netReceivableAmount) {
        this.netReceivableAmount = netReceivableAmount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getBookingCommissionAmount() {
        return bookingCommissionAmount;
    }

    public void setBookingCommissionAmount(BigDecimal bookingCommissionAmount) {
        this.bookingCommissionAmount = bookingCommissionAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public BigDecimal getDeliveryChargeAmount() {
        return deliveryChargeAmount;
    }

    public void setDeliveryChargeAmount(BigDecimal deliveryChargeAmount) {
        this.deliveryChargeAmount = deliveryChargeAmount;
    }
    public String getBusinessServiceName() {
        return businessServiceName;
    }

    public void setBusinessServiceName(String businessServiceName) {
        this.businessServiceName = businessServiceName;
    }
    public BigDecimal getServiceChargeAmount() {
        return serviceChargeAmount;
    }

    public void setServiceChargeAmount(BigDecimal serviceChargeAmount) {
        this.serviceChargeAmount = serviceChargeAmount;
    }
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    public BigDecimal getConvenienceFee() {
        return convenienceFee;
    }

    public void setConvenienceFee(BigDecimal convenienceFee) {
        this.convenienceFee = convenienceFee;
    }
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getPropertyWebsite() {
        return propertyWebsite;
    }

    public void setPropertyWebsite(String propertyWebsite) {
        this.propertyWebsite = propertyWebsite;
    }
    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public java.util.Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public boolean isCreditSettled() {
        return isCreditSettled;
    }

    public void setCreditSettled(boolean creditSettled) {
        isCreditSettled = creditSettled;
    }
    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getDecryptedData() {
        return decryptedData;
    }

    public void setDecryptedData(String decryptedData) {
        this.decryptedData = decryptedData;
    }
    public boolean isChargeAbleToBooking() {
		return isChargeAbleToBooking;
	}

	public void setChargeAbleToBooking(boolean isChargeAbleToBooking) {
		this.isChargeAbleToBooking = isChargeAbleToBooking;
	}

	public String getSourceOfBooking() {
		return sourceOfBooking;
	}

	public void setSourceOfBooking(String sourceOfBooking) {
		this.sourceOfBooking = sourceOfBooking;
	}

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public Integer getLastFourDigitCardNumber() {
		return lastFourDigitCardNumber;
	}

	public void setLastFourDigitCardNumber(Integer lastFourDigitCardNumber) {
		this.lastFourDigitCardNumber = lastFourDigitCardNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
    public String toString() {
        return "PaymentDto [id=" + id + ",paymentMode=\" + paymentMode + \", referenceNumber=" + referenceNumber + ", name=" + name + ", email=" + email
                + ", currency=" + currency + ", token=" + token + ", expYear=" + expYear
                + ", expMonth=" + expMonth + ", cardNumber=" + cardNumber + ", accountNumber=" + accountNumber
                + ", cvv=" + cvv + ", description=" + description + ", status=" + status + ", receiptNumber="
                + receiptNumber + ", failureMessage=" + failureMessage + ", failureCode=" + failureCode + "]";
    }
}
