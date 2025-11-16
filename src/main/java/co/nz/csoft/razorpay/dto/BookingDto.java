package co.nz.csoft.razorpay.dto;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.nz.csoft.razorpay.enums.BookingStatus;




public class BookingDto {

	private Long id;
	private Long roomId;
	private Long propertyId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private java.sql.Date fromDate;
	private java.sql.Date toDate;
	private BigDecimal roomPrice;
	private int noOfNights;
	private String businessName;
	private BigDecimal airportShuttlePrice;
	private BigDecimal totalAmount;
	private String notes;
	private String externalBookingId;
	private String businessEmail;
	private String externalSite;
	private String modeOfPayment;
	private BigDecimal payableAmount;
	private String bookingUrl;
	private String roomName;
	private BigDecimal beforeTaxAmount;
	private BigDecimal taxAmount;
	private BigDecimal totalServiceAmount;
	private BigDecimal serviceAmountPaid;
	private BigDecimal serviceAmountPending;
	private BigDecimal roomTariffAmountPending;
	private BigDecimal roomTariffAmountPaid;
	private BigDecimal totalExpenseAmount;
	private BigDecimal totalPaymentAmount;
	private BigDecimal discountAmount;
	private Double discountPercentage;
	private BigDecimal outstandingAmount;
	private BookingStatus bookingStatus;
	private String invoiceUrl;
	private Integer noOfRooms;
	private Integer noOfPersons;
	private Integer noOfChildren;
	private java.util.Date checkinTime;
	private java.util.Date checkoutTime;
	private BigDecimal extraPersonCharge;
	private BigDecimal extraChildCharge;
	private Integer noOfExtraPerson;
	protected String createdBy;
	protected java.util.Date createdDate;
	protected String lastModifiedBy;
	protected java.util.Date lastModifiedDate;
	private boolean otaBooking;
	private String message;
	private String roomRatePlanName;
	private String planCode;
	private String currency;
	private Boolean isGroupBooking;
	private Long customerId;
	private String propertyReservationNumber;
	private String invoiceId;
	private java.util.Date fromTime;
	private java.util.Date toTime;
	private Double duration;
	private String locationName;
	private String resourceName;
	private String businessTypeName;
	private Long propertyName;
	private String propertyLogoUrl;
	private Long bookOneReviewId;
	private BigDecimal advanceAmount;
	private String arrivingFrom;
	private String departingTo;
	private String purposeOfVisit;
	private String roomNumbers;
	private String nationality;
	private String idDetails;
	private String checkInDateStr;
	private String checkOutDateStr;
	private String counterNumber;
	private String counterName;
	private String operatorName;
	private String customerCompanyName;
	private BigDecimal roomTariffBeforeDiscount;
	private BigDecimal totalRoomTariffBeforeDiscount;
	private Boolean isIncludeService;
	private BigDecimal roomTariffPending;
	private BigDecimal roomTariffPaid;
	private String customerGstNo;
	private String customerImageurl;
	private String hsnCode;
	private BigDecimal convenienceFee;
	private BigDecimal bookingCommissionAmount;
	private Long companyId;
	private Long propertyInvoiceNumber;
	private boolean dayTrip;
	private List<PaymentDto> paymentDtoList;
	// TDS and TCS information
	private BigDecimal tdsFee;
	private BigDecimal tcsFee;

	// MultiBooking invoice
	private Long groupBookingId;
	private Boolean singleBookingInvoice;
	private Boolean multiBookingInvoice;
	private String billNumber;
	private String operatorNotes;
	private int expectedNights;
	private Boolean dateRollOver;
	private Integer checkoutPeriod;
	private boolean twentyFourHoursCheckOut;
	private boolean showDiscount;
	private BigDecimal otaGstAmount;
	private String reviewUrl;
	private Boolean isIncludeExpense;
	private BigDecimal cancellationCharge;
	private String paymentUrl;
	private String voucherUrl;
	private String couponCode;
	private String promotionName;
	
	private List<TaxDetails> taxDetails = new ArrayList<TaxDetails>();
	
	
	
	

	public List<TaxDetails> getTaxDetails() {
		return taxDetails;
	}

	public void setTaxDetails(List<TaxDetails> taxDetails) {
		this.taxDetails = taxDetails;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getVoucherUrl() {
		return voucherUrl;
	}

	public void setVoucherUrl(String voucherUrl) {
		this.voucherUrl = voucherUrl;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public boolean isDayTrip() {
		return dayTrip;
	}

	public void setDayTrip(boolean dayTrip) {
		this.dayTrip = dayTrip;
	}

	public BigDecimal getRoomTariffPending() {
		return roomTariffPending;
	}

	public void setRoomTariffPending(BigDecimal roomTariffPending) {
		this.roomTariffPending = roomTariffPending;
	}

	public BigDecimal getRoomTariffPaid() {
		return roomTariffPaid;
	}

	public void setRoomTariffPaid(BigDecimal roomTariffPaid) {
		this.roomTariffPaid = roomTariffPaid;
	}

	public String getCustomerGstNo() {
		return customerGstNo;
	}

	public void setCustomerGstNo(String customerGstNo) {
		this.customerGstNo = customerGstNo;
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


	public Long getBookOneReviewId() {
		return bookOneReviewId;
	}

	public void setBookOneReviewId(Long bookOneReviewId) {
		this.bookOneReviewId = bookOneReviewId;
	}

	public Long getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(Long propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyLogoUrl() {
		return propertyLogoUrl;
	}

	public void setPropertyLogoUrl(String propertyLogoUrl) {
		this.propertyLogoUrl = propertyLogoUrl;
	}

	public String getPropertyReservationNumber() {
		return propertyReservationNumber;
	}

	public void setPropertyReservationNumber(String propertyReservationNumber) {
		this.propertyReservationNumber = propertyReservationNumber;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public BigDecimal getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(BigDecimal outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getFromDate() {

		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public BigDecimal getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getNoOfNights() {
		return noOfNights;
	}

	public void setNoOfNights(int noOfNights) {
		this.noOfNights = noOfNights;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getAirportShuttlePrice() {
		return airportShuttlePrice;
	}

	public void setAirportShuttlePrice(BigDecimal airportShuttlePrice) {
		this.airportShuttlePrice = airportShuttlePrice;
	}

	public String getBusinessEmail() {
		return businessEmail;
	}

	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getExternalSite() {
		return externalSite;
	}

	public void setExternalSite(String externalSite) {
		this.externalSite = externalSite;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public String getBookingUrl() {
		return bookingUrl;
	}

	public void setBookingUrl(String bookingUrl) {
		this.bookingUrl = bookingUrl;
	}

	public BigDecimal getTotalServiceAmount() {
		return totalServiceAmount;
	}

	public void setTotalServiceAmount(BigDecimal totalServiceAmount) {
		this.totalServiceAmount = totalServiceAmount;
	}

	public BigDecimal getTotalExpenseAmount() {
		return totalExpenseAmount;
	}

	public void setTotalExpenseAmount(BigDecimal totalExpenseAmount) {
		this.totalExpenseAmount = totalExpenseAmount;
	}

	public BigDecimal getTotalPaymentAmount() {
		return totalPaymentAmount;
	}

	public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getInvoiceUrl() {
		return invoiceUrl;
	}

	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

	public Integer getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public Integer getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public java.util.Date getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(java.util.Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	public java.util.Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(java.util.Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public BigDecimal getExtraPersonCharge() {
		return extraPersonCharge;
	}

	public void setExtraPersonCharge(BigDecimal extraPersonCharge) {
		this.extraPersonCharge = extraPersonCharge;
	}

	public Integer getNoOfExtraPerson() {
		return noOfExtraPerson;
	}

	public void setNoOfExtraPerson(Integer noOfExtraPerson) {
		this.noOfExtraPerson = noOfExtraPerson;
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

	public void setCreatedDate(java.util.Date createdDate) {
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

	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isOtaBooking() {
		return otaBooking;
	}

	public void setOtaBooking(boolean otaBooking) {
		this.otaBooking = otaBooking;
	}

	public String getRoomRatePlanName() {
		return roomRatePlanName;
	}

	public void setRoomRatePlanName(String roomRatePlanName) {
		this.roomRatePlanName = roomRatePlanName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Boolean getGroupBooking() {
		return isGroupBooking;
	}

	public Boolean isGroupBooking() {
		return isGroupBooking;
	}

	public void setGroupBooking(Boolean groupBooking) {
		isGroupBooking = groupBooking;
	}

	public String getExternalBookingId() {
		return externalBookingId;
	}

	public void setExternalBookingId(String externalBookingId) {
		this.externalBookingId = externalBookingId;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}

	public BigDecimal getBeforeTaxAmount() {
		return beforeTaxAmount;
	}

	public void setBeforeTaxAmount(BigDecimal beforeTaxAmount) {
		this.beforeTaxAmount = beforeTaxAmount;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(BigDecimal advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public String getArrivingFrom() {
		return arrivingFrom;
	}

	public void setArrivingFrom(String arrivingFrom) {
		this.arrivingFrom = arrivingFrom;
	}

	public String getDepartingTo() {
		return departingTo;
	}

	public void setDepartingTo(String departingTo) {
		this.departingTo = departingTo;
	}

	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}

	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}

	public String getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(String roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(String idDetails) {
		this.idDetails = idDetails;
	}

	public String getCheckInDateStr() {
		return checkInDateStr;
	}

	public void setCheckInDateStr(String checkInDateStr) {
		this.checkInDateStr = checkInDateStr;
	}

	public String getCheckOutDateStr() {
		return checkOutDateStr;
	}

	public void setCheckOutDateStr(String checkOutDateStr) {
		this.checkOutDateStr = checkOutDateStr;
	}

	public Integer getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public BigDecimal getExtraChildCharge() {
		return extraChildCharge;
	}

	public void setExtraChildCharge(BigDecimal extraChildCharge) {
		this.extraChildCharge = extraChildCharge;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getCustomerCompanyName() {
		return customerCompanyName;
	}

	public void setCustomerCompanyName(String customerCompanyName) {
		this.customerCompanyName = customerCompanyName;
	}

	public BigDecimal getRoomTariffBeforeDiscount() {
		return roomTariffBeforeDiscount;
	}

	public void setRoomTariffBeforeDiscount(BigDecimal roomTariffBeforeDiscount) {
		this.roomTariffBeforeDiscount = roomTariffBeforeDiscount;
	}

	public BigDecimal getTotalRoomTariffBeforeDiscount() {
		return totalRoomTariffBeforeDiscount;
	}

	public void setTotalRoomTariffBeforeDiscount(BigDecimal totalRoomTariffBeforeDiscount) {
		this.totalRoomTariffBeforeDiscount = totalRoomTariffBeforeDiscount;
	}

	public Boolean getIncludeService() {
		return isIncludeService;
	}

	public void setIncludeService(Boolean includeService) {
		isIncludeService = includeService;
	}

	public java.util.Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(java.util.Date fromTime) {
		this.fromTime = fromTime;
	}

	public java.util.Date getToTime() {
		return toTime;
	}

	public void setToTime(java.util.Date toTime) {
		this.toTime = toTime;
	}

	public BigDecimal getServiceAmountPaid() {
		return serviceAmountPaid;
	}

	public void setServiceAmountPaid(BigDecimal serviceAmountPaid) {
		this.serviceAmountPaid = serviceAmountPaid;
	}

	public BigDecimal getServiceAmountPending() {
		return serviceAmountPending;
	}

	public void setServiceAmountPending(BigDecimal serviceAmountPending) {
		this.serviceAmountPending = serviceAmountPending;
	}

	public BigDecimal getRoomTariffAmountPending() {
		return roomTariffAmountPending;
	}

	public void setRoomTariffAmountPending(BigDecimal roomTariffAmountPending) {
		this.roomTariffAmountPending = roomTariffAmountPending;
	}

	public BigDecimal getRoomTariffAmountPaid() {
		return roomTariffAmountPaid;
	}

	public void setRoomTariffAmountPaid(BigDecimal roomTariffAmountPaid) {
		this.roomTariffAmountPaid = roomTariffAmountPaid;
	}

	public String getCustomerImageurl() {
		return customerImageurl;
	}

	public void setCustomerImageurl(String customerImageurl) {
		this.customerImageurl = customerImageurl;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public BigDecimal getConvenienceFee() {
		return convenienceFee;
	}

	public void setConvenienceFee(BigDecimal convenienceFee) {
		this.convenienceFee = convenienceFee;
	}

	public BigDecimal getBookingCommissionAmount() {
		return bookingCommissionAmount;
	}

	public void setBookingCommissionAmount(BigDecimal bookingCommissionAmount) {
		this.bookingCommissionAmount = bookingCommissionAmount;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getPropertyInvoiceNumber() {
		return propertyInvoiceNumber;
	}

	public void setPropertyInvoiceNumber(Long propertyInvoiceNumber) {
		this.propertyInvoiceNumber = propertyInvoiceNumber;
	}

	public List<PaymentDto> getPaymentDtoList() {
		return paymentDtoList;
	}

	public void setPaymentDtoList(List<PaymentDto> paymentDtoList) {
		this.paymentDtoList = paymentDtoList;
	}

	public Boolean getIsGroupBooking() {
		return isGroupBooking;
	}

	public void setIsGroupBooking(Boolean isGroupBooking) {
		this.isGroupBooking = isGroupBooking;
	}

	public Boolean getIsIncludeService() {
		return isIncludeService;
	}

	public void setIsIncludeService(Boolean isIncludeService) {
		this.isIncludeService = isIncludeService;
	}

	public BigDecimal getTdsFee() {
		return tdsFee;
	}

	public void setTdsFee(BigDecimal tdsFee) {
		this.tdsFee = tdsFee;
	}

	public BigDecimal getTcsFee() {
		return tcsFee;
	}

	public void setTcsFee(BigDecimal tcsFee) {
		this.tcsFee = tcsFee;
	}

	public Long getGroupBookingId() {
		return groupBookingId;
	}

	public void setGroupBookingId(Long groupBookingId) {
		this.groupBookingId = groupBookingId;
	}

	public Boolean getSingleBookingInvoice() {
		return singleBookingInvoice;
	}

	public void setSingleBookingInvoice(Boolean singleBookingInvoice) {
		this.singleBookingInvoice = singleBookingInvoice;
	}

	public Boolean getMultiBookingInvoice() {
		return multiBookingInvoice;
	}

	public void setMultiBookingInvoice(Boolean multiBookingInvoice) {
		this.multiBookingInvoice = multiBookingInvoice;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getOperatorNotes() {
		return operatorNotes;
	}

	public void setOperatorNotes(String operatorNotes) {
		this.operatorNotes = operatorNotes;
	}
	
	public int getExpectedNights() {
		return expectedNights;
	}

	public void setExpectedNights(int expectedNights) {
		this.expectedNights = expectedNights;
	}
	public Boolean getDateRollOver() {
		return dateRollOver;
	}

	public void setDateRollOver(Boolean dateRollOver) {
		this.dateRollOver = dateRollOver;
	}

	public Integer getCheckoutPeriod() {
		return checkoutPeriod;
	}

	public void setCheckoutPeriod(Integer checkoutPeriod) {
		this.checkoutPeriod = checkoutPeriod;
	}

	public boolean isTwentyFourHoursCheckOut() {
		return twentyFourHoursCheckOut;
	}

	public void setTwentyFourHoursCheckOut(boolean twentyFourHoursCheckOut) {
		this.twentyFourHoursCheckOut = twentyFourHoursCheckOut;
	}
	public boolean isShowDiscount() {
		return showDiscount;
	}

	public void setShowDiscount(boolean showDiscount) {
		this.showDiscount = showDiscount;
	}

	public BigDecimal getOtaGstAmount() {
		return otaGstAmount;
	}

	public void setOtaGstAmount(BigDecimal otaGstAmount) {
		this.otaGstAmount = otaGstAmount;
	}
	public String getReviewUrl() {
		return reviewUrl;
	}

	public void setReviewUrl(String reviewUrl) {
		this.reviewUrl = reviewUrl;
	}

	public Boolean getIsIncludeExpense() {
		return isIncludeExpense;
	}

	public void setIsIncludeExpense(Boolean isIncludeExpense) {
		this.isIncludeExpense = isIncludeExpense;
	}

	public BigDecimal getCancellationCharge() {
		return cancellationCharge;
	}

	public void setCancellationCharge(BigDecimal cancellationCharge) {
		this.cancellationCharge = cancellationCharge;
	}
	
	@Override
	public String toString() {
	    return "BookingDto{" +
	            "id=" + id +
	            ", roomId=" + roomId +
	            ", propertyId=" + propertyId +
	            ", firstName='" + firstName + '\'' +
	            ", lastName='" + lastName + '\'' +
	            ", email='" + email + '\'' +
	            ", mobile='" + mobile + '\'' +
	            ", fromDate=" + fromDate +
	            ", toDate=" + toDate +
	            ", roomPrice=" + roomPrice +
	            ", noOfNights=" + noOfNights +
	            ", businessName='" + businessName + '\'' +
	            ", airportShuttlePrice=" + airportShuttlePrice +
	            ", totalAmount=" + totalAmount +
	            ", notes='" + notes + '\'' +
	            ", externalBookingId='" + externalBookingId + '\'' +
	            ", businessEmail='" + businessEmail + '\'' +
	            ", externalSite='" + externalSite + '\'' +
	            ", modeOfPayment='" + modeOfPayment + '\'' +
	            ", payableAmount=" + payableAmount +
	            ", bookingUrl='" + bookingUrl + '\'' +
	            ", roomName='" + roomName + '\'' +
	            ", beforeTaxAmount=" + beforeTaxAmount +
	            ", taxAmount=" + taxAmount +
	            ", totalServiceAmount=" + totalServiceAmount +
	            ", serviceAmountPaid=" + serviceAmountPaid +
	            ", serviceAmountPending=" + serviceAmountPending +
	            ", roomTariffAmountPending=" + roomTariffAmountPending +
	            ", roomTariffAmountPaid=" + roomTariffAmountPaid +
	            ", totalExpenseAmount=" + totalExpenseAmount +
	            ", totalPaymentAmount=" + totalPaymentAmount +
	            ", discountAmount=" + discountAmount +
	            ", discountPercentage=" + discountPercentage +
	            ", outstandingAmount=" + outstandingAmount +
	            ", bookingStatus=" + bookingStatus +
	            ", invoiceUrl='" + invoiceUrl + '\'' +
	            ", noOfRooms=" + noOfRooms +
	            ", noOfPersons=" + noOfPersons +
	            ", noOfChildren=" + noOfChildren +
	            ", checkinTime=" + checkinTime +
	            ", checkoutTime=" + checkoutTime +
	            ", extraPersonCharge=" + extraPersonCharge +
	            ", extraChildCharge=" + extraChildCharge +
	            ", noOfExtraPerson=" + noOfExtraPerson +
	            ", createdBy='" + createdBy + '\'' +
	            ", createdDate=" + createdDate +
	            ", lastModifiedBy='" + lastModifiedBy + '\'' +
	            ", lastModifiedDate=" + lastModifiedDate +
	            ", otaBooking=" + otaBooking +
	            ", message='" + message + '\'' +
	            ", roomRatePlanName='" + roomRatePlanName + '\'' +
	            ", planCode='" + planCode + '\'' +
	            ", currency='" + currency + '\'' +
	            ", isGroupBooking=" + isGroupBooking +
	            ", customerId=" + customerId +
	            ", propertyReservationNumber='" + propertyReservationNumber + '\'' +
	            ", invoiceId='" + invoiceId + '\'' +
	            ", fromTime=" + fromTime +
	            ", toTime=" + toTime +
	            ", duration=" + duration +
	            ", locationName='" + locationName + '\'' +
	            ", resourceName='" + resourceName + '\'' +
	            ", businessTypeName='" + businessTypeName + '\'' +
	            ", propertyName=" + propertyName +
	            ", propertyLogoUrl='" + propertyLogoUrl + '\'' +
	            ", bookOneReviewId=" + bookOneReviewId +
	            ", advanceAmount=" + advanceAmount +
	            ", arrivingFrom='" + arrivingFrom + '\'' +
	            ", departingTo='" + departingTo + '\'' +
	            ", purposeOfVisit='" + purposeOfVisit + '\'' +
	            ", roomNumbers='" + roomNumbers + '\'' +
	            ", nationality='" + nationality + '\'' +
	            ", idDetails='" + idDetails + '\'' +
	            ", checkInDateStr='" + checkInDateStr + '\'' +
	            ", checkOutDateStr='" + checkOutDateStr + '\'' +
	            ", counterNumber='" + counterNumber + '\'' +
	            ", counterName='" + counterName + '\'' +
	            ", operatorName='" + operatorName + '\'' +
	            ", customerCompanyName='" + customerCompanyName + '\'' +
	            ", roomTariffBeforeDiscount=" + roomTariffBeforeDiscount +
	            ", totalRoomTariffBeforeDiscount=" + totalRoomTariffBeforeDiscount +
	            ", isIncludeService=" + isIncludeService +
	            ", roomTariffPending=" + roomTariffPending +
	            ", roomTariffPaid=" + roomTariffPaid +
	            ", customerGstNo='" + customerGstNo + '\'' +
	            ", customerImageurl='" + customerImageurl + '\'' +
	            ", hsnCode='" + hsnCode + '\'' +
	            ", convenienceFee=" + convenienceFee +
	            ", bookingCommissionAmount=" + bookingCommissionAmount +
	            ", companyId=" + companyId +
	            ", propertyInvoiceNumber=" + propertyInvoiceNumber +
	            ", dayTrip=" + dayTrip +
	            ", paymentDtoList=" + paymentDtoList +
	            ", tdsFee=" + tdsFee +
	            ", tcsFee=" + tcsFee +
	            ", groupBookingId=" + groupBookingId +
	            ", singleBookingInvoice=" + singleBookingInvoice +
	            ", multiBookingInvoice=" + multiBookingInvoice +
	            ", billNumber='" + billNumber + '\'' +
	            ", operatorNotes='" + operatorNotes + '\'' +
	            ", expectedNights=" + expectedNights +
	            ", dateRollOver=" + dateRollOver +
	            ", checkoutPeriod=" + checkoutPeriod +
	            ", twentyFourHoursCheckOut=" + twentyFourHoursCheckOut +
	            ", showDiscount=" + showDiscount +
	            ", otaGstAmount=" + otaGstAmount +
	            ", reviewUrl='" + reviewUrl + '\'' +
	            ", isIncludeExpense=" + isIncludeExpense +
	            ", cancellationCharge=" + cancellationCharge +
	            ", paymentUrl='" + paymentUrl + '\'' +
	            ", voucherUrl='" + voucherUrl + '\'' +
	            '}';
	}


}
