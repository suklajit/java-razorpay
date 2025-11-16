package co.nz.csoft.razorpay.dto;

import java.math.BigDecimal;

public class WhatsappEnquiry {
	private Long id;
    private Long accommodationEnquiryId;
    private String checkInDate;
    private String checkOutDate;
    private String fullName;
    private String email;
    private Integer rooms;
    private Integer adults;
    private Integer children;
    private String couponCode;
    private Long propertyId;
    private String propertyName;
    private String mobile;
    private String bookingConvert;
    private BigDecimal paidAmount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAccommodationEnquiryId() {
		return accommodationEnquiryId;
	}
	public void setAccommodationEnquiryId(Long accommodationEnquiryId) {
		this.accommodationEnquiryId = accommodationEnquiryId;
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRooms() {
		return rooms;
	}
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	public Integer getAdults() {
		return adults;
	}
	public void setAdults(Integer adults) {
		this.adults = adults;
	}
	public Integer getChildren() {
		return children;
	}
	public void setChildren(Integer children) {
		this.children = children;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBookingConvert() {
		return bookingConvert;
	}
	public void setBookingConvert(String bookingConvert) {
		this.bookingConvert = bookingConvert;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
    

}
