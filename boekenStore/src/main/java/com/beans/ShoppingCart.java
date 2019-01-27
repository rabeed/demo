package com.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.model.Product;
import com.model.ShoppingCartLine;

@Named
@SessionScoped
//@StatefulTimeout()
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<ShoppingCartLine> lines = new ArrayList<ShoppingCartLine>();
	private int total = 0;
	private BigDecimal totalAmount = BigDecimal.ZERO;



	@Inject
	private Event<Product> purchaseOrderEvent; 
	
	
	
	public ShoppingCart() {

	}

	public List<ShoppingCartLine> getLines() {
		return lines;
	}

	public BigDecimal getTotalAmount() {

		return lines.stream().map(ShoppingCartLine::getAmount).reduce(BigDecimal::add).get();
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
	
		this.total = total;
	}
	
	public int getTotalAllItems()
	{
		int i = lines.stream().mapToInt(e->e.getQuantity()).sum();
		return i ;
	}

	public void addProduct(Product p) {
		boolean find = lines.stream().anyMatch(l -> l.getProduct().equals(p));

		// Optional<ShoppingCartLine> ll =
		// lines.stream().filter(l->l.getProduct().equals(p)).findFirst();
		ShoppingCartLine line = new ShoppingCartLine(p);
		purchaseOrderEvent.fire(p);
		if (!find)
			this.lines.add(line);

	}

	public void addMoreItems(Product p) {
		Optional<ShoppingCartLine> ll = lines.stream().filter(l -> l.getProduct().equals(p)).findFirst();
		ll.get().setQuantity(ll.get().getQuantity() + 1);
	}

	public void removeProduct(Product p) {
		Optional<ShoppingCartLine> ll = lines.stream().filter(l -> l.getProduct().equals(p)).findFirst();
		this.lines.remove(ll.get());
	}

}
