package co.nz.csoft.razorpay.enums;

public enum BookingStatus {
    NEW("NEW"),
	AVAILABLE("AVAILABLE"),
	PENDING("PENDING"),
	CANCELLED("CANCELLED"),
	CONFIRMED("CONFIRMED"),
	CHECKEDIN("CHECKEDIN"),
	GROUP_CHECKEDIN("GROUP CHECKEDIN"),
	CHECKEDOUT("CHECKEDOUT"),
	ENQUIRY("ENQUIRY"),
	GROUP_CHECKEDOUT("GROUP CHECKOUT"),
    VOID("VOID"),
	NO_SHOW("NO SHOW"),
	MODIFY("MODIFY");
	private String status;
	BookingStatus(String status)
	{
		this.status=status;
	}
    public String getValue()
    { 
    	return status; 
    }
}