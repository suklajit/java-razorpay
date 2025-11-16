package co.nz.csoft.razorpay.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;





public class ExternalReservationDto {

    private Long id;
    private String channelId;
    private String externalTransactionId;
    private String bookoneReservationId;
//    @Temporal(TIMESTAMP)
    private Date createdTimestamp;
//    @Temporal(TIMESTAMP)
    private Date updatedTimestamp;
   // private ProcessingStatus status;
    private String payloadType;
    private String otaName;
    private String otaReservationId;
    private String checkinDate;
    private String checkoutDate;
    private String propertyName;
    private String propertyId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String notes;
    private BigDecimal totalAmount;
    private BigDecimal amountBeforeTax;
    private BigDecimal taxAmount;
    private String  currency;
    private BigDecimal paidAmount;
    private String modeOfPayment;
    private String bookingStatus;
    private String propertyBusinessEmail;
    private String noOfPerson;

    private String resType;
    private String couponCode;
    private String promotionName;

   // private List<RoomDetail> roomDetail=new ArrayList<RoomDetail>();
    private List<RoomDetail> roomDetails = new ArrayList<>();


    //private Address address;
    private Integer noOfChildrenAbove5Years;
    
    private String createdBy;
    
    
    
    
    public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public Integer getNoOfChildrenAbove5Years() {
		return noOfChildrenAbove5Years;
	}

	public void setNoOfChildrenAbove5Years(Integer noOfChildrenAbove5Years) {
		this.noOfChildrenAbove5Years = noOfChildrenAbove5Years;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }



    public String getOtaReservationId() {
        return otaReservationId;
    }

    public void setOtaReservationId(String otaReservationId) {
        this.otaReservationId = otaReservationId;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
    public String getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(String noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getBookoneReservationId() {
        return bookoneReservationId;
    }

    public void setBookoneReservationId(String bookoneReservationId) {
        this.bookoneReservationId = bookoneReservationId;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }



//    public ProcessingStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(ProcessingStatus status) {
//        this.status = status;
//    }
    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }
    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    public String getPropertyBusinessEmail() {
        return propertyBusinessEmail;
    }

    public void setPropertyBusinessEmail(String propertyBusinessEmail) {
        this.propertyBusinessEmail = propertyBusinessEmail;
    }
/*
    public List<RoomDetail> getRoomDetail() {
		return roomDetail;
	}

	public void setRoomDetail(List<RoomDetail> roomDetail) {
		this.roomDetail = roomDetail;
	}
	*/
	public List<RoomDetail> getRoomDetails() {
	    return roomDetails;
	}

	public void setRoomDetails(List<RoomDetail> roomDetails) {
	    this.roomDetails = roomDetails;
	}

	public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public BigDecimal getAmountBeforeTax() {
        return amountBeforeTax;
    }

    public void setAmountBeforeTax(BigDecimal amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExternalReservationDto that = (ExternalReservationDto) o;
        return
                Objects.equals(channelId, that.channelId) &&
                Objects.equals(externalTransactionId, that.externalTransactionId);

    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, externalTransactionId);
    }


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", externalTransactionId='" + externalTransactionId + '\'' +
                ", bookoneReservationId='" + bookoneReservationId + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                ", payloadType='" + payloadType + '\'' +
                ", otaName='" + otaName + '\'' +
                ", otaReservationId='" + otaReservationId + '\'' +
                ", checkinDate='" + checkinDate + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", notes='" + notes + '\'' +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", propertyBusinessEmail='" + propertyBusinessEmail + '\'' +
                ", noOfPerson='" + noOfPerson + '\'' +
               // ", resStatus'" + resStatus + '\'' +
                ", resType'" + resType + '\'' +
                ", roomDetails=" + roomDetails +
                '}';
    }
}

