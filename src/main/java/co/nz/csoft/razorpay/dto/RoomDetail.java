package co.nz.csoft.razorpay.dto;

import java.io.Serializable;

public class RoomDetail implements Serializable {
	private String roomTypeId;
	private String roomTypeName;
	private Double roomRate;
	private String plan;
	private Integer noOfRooms;
	private Integer noOfadult;
	private Integer noOfchild;
	private String checkinDate;
	private String checkoutDate;

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public Double getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(Double roomRate) {
		this.roomRate = roomRate;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public Integer getNoOfadult() {
		return noOfadult;
	}

	public void setNoOfadult(Integer noOfadult) {
		this.noOfadult = noOfadult;
	}

	public Integer getNoOfchild() {
		return noOfchild;
	}

	public void setNoOfchild(Integer noOfchild) {
		this.noOfchild = noOfchild;
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

	@Override
	public String toString() {
		return "{" + "roomTypeId=" + roomTypeId + ", roomTypeName='" + roomTypeName + '\'' + ", roomRate='" + roomRate
				+ '\'' + ", plan='" + plan + '\'' + ", noOfRooms='" + noOfRooms + '\'' + ", noOfchild='" + noOfchild
				+ '\'' + ", noOfadult=" + noOfadult + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate
				+ '}';
	}

}
