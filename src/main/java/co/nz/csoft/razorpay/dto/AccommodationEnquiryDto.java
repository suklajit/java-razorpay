package co.nz.csoft.razorpay.dto;
import java.math.BigDecimal;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import co.nz.csoft.razorpay.enums.PaymentStatus;

public class AccommodationEnquiryDto {

    private Long enquiryId;
    private String fromEmail;
    private String toEmail;
    private String fromName;
    private String toName;
    private String bccEmail;
    private String bccName;
    private String firstName;
    private String lastName;
    private String accommodationType;
    private int noOfPerson;
    private int noOfRooms;
    private int noOfChildren;
    private int noOfPets;
    private String location;
    private String alternativeLocation;
    private String phone;
    private String email;
    private String checkInDate;
    private String checkOutDate;
    private String foodOptions;
    private String dietaryRequirement;
    private int min;
    private int max;
    private String specialNotes;
    private String status;
    private String consultantPerson;
    private String accountManager;
    private Long organisationId;
    private Long propertyId;
    private String propertyName;
    private String bccEmailTo;
    private Date createdDate;
    private Boolean dateRollOver;
    private BigDecimal roomPrice;
    private String roomName;
    private String roomRatePlanName;
    private int noOfNights;
    private int expectedNights;
    private Integer noOfExtraPerson;
    private BigDecimal extraPersonCharge;
    private BigDecimal extraChildCharge;
    private BigDecimal roomTariffBeforeDiscount;
    private BigDecimal totalBookingAmount;
    private java.util.Date toTime;
    private java.util.Date fromTime;
    private BigDecimal taxAmount;
    private BigDecimal payableAmount;
    private BigDecimal totalAmount;
    private BigDecimal beforeTaxAmount;
    private BigDecimal outstandingAmount;
    private String modeOfPayment;
    private PaymentStatus paymentStatus;
    private Date fromDate;
    private Date toDate;
    private Integer noOfExtraChild;
    private BigDecimal netAmount;
    private Double taxPercentage;
    private String planCode;
    private String roomType;
    private Long roomId;
    private String includeService;
    private BigDecimal discountAmount;
    private boolean dayTrip;
    private BigDecimal gstAmount;
    private String mobile;
    private Long customerId;
    private BigDecimal advanceAmount;
    private String externalSite;
    private String businessName;
    private String businessEmail;
    private boolean roomBooking;
    private BigDecimal bookingAmount;
    private boolean groupBooking;
    private int available;
    private String currency;
    private Long bookingPropertyId;
    private String bookingReservationId;
    private List<TaxDetails> taxDetails = new ArrayList<TaxDetails>();
    private Boolean paymentReceived;
    private String source;
   // private Address address;
    private String policy;

    private BigDecimal tdsFee;
    private BigDecimal tcsFee;
    private BigDecimal bookingCommissionAmount;

    private BigDecimal withGstAmount;
    private BigDecimal withOutGstAmount;
    private BigDecimal hotelmateCommissionAmount;
    private Date updatedDate;
    private String updatedBy;
    private String reason;
    private Double discountAmountPercentage;
    private Double hotelmateCommissionAmountPercentage;
    private Double tcsFeePercentage;
    private Double tdsFeePercentage;
    private String createdBy;
    private Long bookingId;

    private String eventName;
    private BigDecimal eventPrice;
    private BigDecimal eventComission;

    private String couponCode;
    private String promotionName;
    private Long groupEnquiryId;
    private String enquiryType;
	private String utmSource;
	private String utmMedium;
	
    




    public String getUtmSource() {
		return utmSource;
	}

	public void setUtmSource(String utmSource) {
		this.utmSource = utmSource;
	}

	public String getUtmMedium() {
		return utmMedium;
	}

	public void setUtmMedium(String utmMedium) {
		this.utmMedium = utmMedium;
	}

	public String getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}

	public Long getGroupEnquiryId() {
		return groupEnquiryId;
	}

	public void setGroupEnquiryId(Long groupEnquiryId) {
		this.groupEnquiryId = groupEnquiryId;
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(BigDecimal eventPrice) {
        this.eventPrice = eventPrice;
    }

    public BigDecimal getEventComission() {
        return eventComission;
    }

    public void setEventComission(BigDecimal eventComission) {
        this.eventComission = eventComission;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Double getDiscountAmountPercentage() {
        return discountAmountPercentage;
    }

    public void setDiscountAmountPercentage(Double discountAmountPercentage) {
        this.discountAmountPercentage = discountAmountPercentage;
    }

    public Double getHotelmateCommissionAmountPercentage() {
        return hotelmateCommissionAmountPercentage;
    }

    public void setHotelmateCommissionAmountPercentage(Double hotelmateCommissionAmountPercentage) {
        this.hotelmateCommissionAmountPercentage = hotelmateCommissionAmountPercentage;
    }

    public Double getTcsFeePercentage() {
        return tcsFeePercentage;
    }

    public void setTcsFeePercentage(Double tcsFeePercentage) {
        this.tcsFeePercentage = tcsFeePercentage;
    }

    public Double getTdsFeePercentage() {
        return tdsFeePercentage;
    }

    public void setTdsFeePercentage(Double tdsFeePercentage) {
        this.tdsFeePercentage = tdsFeePercentage;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getHotelmateCommissionAmount() {
        return hotelmateCommissionAmount;
    }

    public void setHotelmateCommissionAmount(BigDecimal hotelmateCommissionAmount) {
        this.hotelmateCommissionAmount = hotelmateCommissionAmount;
    }

    public BigDecimal getWithGstAmount() {
        return withGstAmount;
    }

    public void setWithGstAmount(BigDecimal withGstAmount) {
        this.withGstAmount = withGstAmount;
    }

    public BigDecimal getWithOutGstAmount() {
        return withOutGstAmount;
    }

    public void setWithOutGstAmount(BigDecimal withOutGstAmount) {
        this.withOutGstAmount = withOutGstAmount;
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

    public BigDecimal getBookingCommissionAmount() {
        return bookingCommissionAmount;
    }

    public void setBookingCommissionAmount(BigDecimal bookingCommissionAmount) {
        this.bookingCommissionAmount = bookingCommissionAmount;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public Integer getNoOfExtraChild() {
        return noOfExtraChild;
    }

    public void setNoOfExtraChild(Integer noOfExtraChild) {
        this.noOfExtraChild = noOfExtraChild;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getIncludeService() {
        return includeService;
    }

    public void setIncludeService(String includeService) {
        this.includeService = includeService;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean isDayTrip() {
        return dayTrip;
    }

    public void setDayTrip(boolean dayTrip) {
        this.dayTrip = dayTrip;
    }

    public BigDecimal getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(BigDecimal gstAmount) {
        this.gstAmount = gstAmount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(BigDecimal advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public String getExternalSite() {
        return externalSite;
    }

    public void setExternalSite(String externalSite) {
        this.externalSite = externalSite;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public boolean isRoomBooking() {
        return roomBooking;
    }

    public void setRoomBooking(boolean roomBooking) {
        this.roomBooking = roomBooking;
    }

    public BigDecimal getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(BigDecimal bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public boolean isGroupBooking() {
        return groupBooking;
    }

    public void setGroupBooking(boolean groupBooking) {
        this.groupBooking = groupBooking;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getDateRollOver() {
        return dateRollOver;
    }

    public void setDateRollOver(Boolean dateRollOver) {
        this.dateRollOver = dateRollOver;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomRatePlanName() {
        return roomRatePlanName;
    }

    public void setRoomRatePlanName(String roomRatePlanName) {
        this.roomRatePlanName = roomRatePlanName;
    }

    public int getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(int noOfNights) {
        this.noOfNights = noOfNights;
    }

    public int getExpectedNights() {
        return expectedNights;
    }

    public void setExpectedNights(int expectedNights) {
        this.expectedNights = expectedNights;
    }

    public Integer getNoOfExtraPerson() {
        return noOfExtraPerson;
    }

    public void setNoOfExtraPerson(Integer noOfExtraPerson) {
        this.noOfExtraPerson = noOfExtraPerson;
    }

    public BigDecimal getExtraPersonCharge() {
        return extraPersonCharge;
    }

    public void setExtraPersonCharge(BigDecimal extraPersonCharge) {
        this.extraPersonCharge = extraPersonCharge;
    }

    public BigDecimal getExtraChildCharge() {
        return extraChildCharge;
    }

    public void setExtraChildCharge(BigDecimal extraChildCharge) {
        this.extraChildCharge = extraChildCharge;
    }

    public BigDecimal getRoomTariffBeforeDiscount() {
        return roomTariffBeforeDiscount;
    }

    public void setRoomTariffBeforeDiscount(BigDecimal roomTariffBeforeDiscount) {
        this.roomTariffBeforeDiscount = roomTariffBeforeDiscount;
    }

    public BigDecimal getTotalBookingAmount() {
        return totalBookingAmount;
    }

    public void setTotalBookingAmount(BigDecimal totalBookingAmount) {
        this.totalBookingAmount = totalBookingAmount;
    }

    public java.util.Date getToTime() {
        return toTime;
    }

    public void setToTime(java.util.Date toTime) {
        this.toTime = toTime;
    }

    public java.util.Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(java.util.Date fromTime) {
        this.fromTime = fromTime;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getBeforeTaxAmount() {
        return beforeTaxAmount;
    }

    public void setBeforeTaxAmount(BigDecimal beforeTaxAmount) {
        this.beforeTaxAmount = beforeTaxAmount;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }



    public Long getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Long enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getBccEmail() {
        return bccEmail;
    }

    public void setBccEmail(String bccEmail) {
        this.bccEmail = bccEmail;
    }

    public String getBccName() {
        return bccName;
    }

    public void setBccName(String bccName) {
        this.bccName = bccName;
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

    public String getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public int getNoOfPets() {
        return noOfPets;
    }

    public void setNoOfPets(int noOfPets) {
        this.noOfPets = noOfPets;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getAlternativeLocation() {
        return alternativeLocation;
    }

    public void setAlternativeLocation(String alternativeLocation) {
        this.alternativeLocation = alternativeLocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getFoodOptions() {
        return foodOptions;
    }

    public void setFoodOptions(String foodOptions) {
        this.foodOptions = foodOptions;
    }

    public String getDietaryRequirement() {
        return dietaryRequirement;
    }

    public void setDietaryRequirement(String dietaryRequirement) {
        this.dietaryRequirement = dietaryRequirement;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsultantPerson() {
        return consultantPerson;
    }

    public void setConsultantPerson(String consultantPerson) {
        this.consultantPerson = consultantPerson;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getBccEmailTo() {
        return bccEmailTo;
    }

    public void setBccEmailTo(String bccEmailTo) {
        this.bccEmailTo = bccEmailTo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getBookingPropertyId() {
        return bookingPropertyId;
    }

    public void setBookingPropertyId(Long bookingPropertyId) {
        this.bookingPropertyId = bookingPropertyId;
    }

    public String getBookingReservationId() {
        return bookingReservationId;
    }

    public void setBookingReservationId(String bookingReservationId) {
        this.bookingReservationId = bookingReservationId;
    }

    public List<TaxDetails> getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(List<TaxDetails> taxDetails) {
        this.taxDetails = taxDetails;
    }

    public Boolean getPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(Boolean paymentReceived) {
        this.paymentReceived = paymentReceived;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "AccommodationEnquiryDto [enquiryId=" + enquiryId + ", fromEmail=" + fromEmail + ", toEmail=" + toEmail
                + ", fromName=" + fromName + ", toName=" + toName + ", bccEmail=" + bccEmail + ", bccName=" + bccName
                + ", firstName=" + firstName + ", lastName=" + lastName + ", accommodationType=" + accommodationType
                + ", noOfPerson=" + noOfPerson + ", noOfRooms=" + noOfRooms + ", noOfChildren=" + noOfChildren
                + ", noOfPets=" + noOfPets + ", location=" + location + ", policy=" + policy
                + ", alternativeLocation=" + alternativeLocation + ", phone=" + phone + ", email=" + email
                + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", foodOptions=" + foodOptions
                + ", dietaryRequirement=" + dietaryRequirement + ", min=" + min + ", max=" + max + ", specialNotes="
                + specialNotes + ", status=" + status + ", consultantPerson=" + consultantPerson + ", accountManager="
                + accountManager + ", organisationId=" + organisationId + ",propertyId=" + propertyId + ",propertyName="
                + propertyName + ",bccEmailTo=" + bccEmailTo +  ",hotelmateCommissionAmount=" + hotelmateCommissionAmount + ",withGstAmount=" + withGstAmount + ",withOutGstAmount=" + withOutGstAmount + ",tdsFee=" + tdsFee+ ",tcsFee=" + tcsFee +  ",bookingCommissionAmount=" + bookingCommissionAmount + ",createdDate=" + createdDate + "]";
    }

}