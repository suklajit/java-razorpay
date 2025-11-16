package co.nz.csoft.razorpay.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaxSlabs implements Serializable {
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Double percentage;

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}

