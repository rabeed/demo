package com.model;

import java.math.BigDecimal;

public class ShoppingCartLine {

	private Product product;
	private int quantity;
	private BigDecimal amount;

	public ShoppingCartLine(Product product) {

		this.product = product;
		this.quantity = 1;
		this.amount = product.getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		double r = product.getPrice().doubleValue() * quantity;
		this.amount = BigDecimal.valueOf(r);
		return BigDecimal.valueOf(r);
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartLine other = (ShoppingCartLine) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	

}
