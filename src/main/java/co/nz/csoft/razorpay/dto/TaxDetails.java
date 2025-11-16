package co.nz.csoft.razorpay.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class TaxDetails implements Serializable {
	private String name;
	private Double percentage;
	private String country;
	private String state;
	private BigDecimal taxableAmount;
	private BigDecimal taxAmount;
	private List<TaxSlabs> taxSlabsList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(BigDecimal taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public List<TaxSlabs> getTaxSlabsList() {
		return taxSlabsList;
	}

	public void setTaxSlabsList(List<TaxSlabs> taxSlabsList) {
		this.taxSlabsList = taxSlabsList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TaxDetails that = (TaxDetails) o;
		return Objects.equals(name, that.name) && Objects.equals(country, that.country)
				&& Objects.equals(state, that.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, country, state);
	}

}
