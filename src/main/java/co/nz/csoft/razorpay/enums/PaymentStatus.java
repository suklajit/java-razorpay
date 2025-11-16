package co.nz.csoft.razorpay.enums;

public enum PaymentStatus {
    Paid("Paid"),
    PartiallyPaid("PartiallyPaid"),
    NotPaid("NotPaid"),
    Quote("Quote");
    private String paymentMode;
    PaymentStatus(String paymentMode)
    {
        this.paymentMode=paymentMode;
    }
    public String getValue()
    {
        return paymentMode;
    }
}