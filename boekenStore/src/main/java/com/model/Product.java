package com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final long id;
	private final String name;
	private final String description;
	private final BigDecimal price;
	private final String imageName;

	public Product(long id, String name, String description, BigDecimal price, String imageName) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageName = imageName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getImageName() {
		return imageName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
