package co.nz.csoft.razorpay.dto;

import java.math.BigDecimal;

public class PaymentReceiveDto {
    private String invoiceId;
    private boolean partialPaid;
    private BigDecimal pricePaid;
    private boolean paymentFailed;

    public boolean isPaymentFailed() {
        return paymentFailed;
    }

    public void setPaymentFailed(boolean paymentFailed) {
        this.paymentFailed = paymentFailed;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public boolean isPartialPaid() {
        return partialPaid;
    }

    public void setPartialPaid(boolean partialPaid) {
        this.partialPaid = partialPaid;
    }

    public BigDecimal getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(BigDecimal pricePaid) {
        this.pricePaid = pricePaid;
    }

    @Override
    public String toString() {
        return "PaymentReceiveDto{" +
                "invoiceId='" + invoiceId + '\'' +
                ", partialPaid=" + partialPaid +
                ", pricePaid=" + pricePaid +
                ", paymentFailed=" + paymentFailed +
                '}';
    }
}
