package co.nz.csoft.razorpay.enums;

public enum PaymentMode {
    Card("Card"),
    Cash("Cash"),
    BankTransfer("BankTransfer"),
    PrePaid("PrePaid"),
    Wallet("Wallet"),
    Cheque("Cheque"),
    DemandDraft("DemandDraft"),
    PaymentTerminal("PaymentTerminal"),
    UPI("UPI"),
    BillToRoom("BillToRoom"),
    MultiModePymt("Multi Mode Pymt"),
    Credit("Credit"),
    PayTM("PayTM"),
    PhonePay("PhonePay"),
    GooglePay("GooglePay"),
    AmazonPay("AmazonPay"),
    BharatPay("BharatPay"),
    PostPay("PostPay"),
    PayPal("PayPal"),
    OYOPaid("OYOPaid"),
    OTAPaid("OTAPaid"),
    FabPaid("FabPaid"),
    Razorpay("Razorpay"),
    PettyCash("PettyCash");
	
	
    private String paymentMode;
    
    PaymentMode(String paymentMode)
    {
        this.paymentMode=paymentMode;
    }
    public String getValue()
    {
        return paymentMode;
    }
}