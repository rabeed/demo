package com.checkout.flow;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.faces.flow.FlowScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.beans.UserManager;
import com.model.User;

@Named
@FlowScoped(value = "checkout")
public class Checkout implements Serializable {

	private String shippingName;
	private String shippingAddress;
	private String shippingCity;
	private String paymentName;
	private CreditCardType creditCard;
	private String creditCardNumber;
	private boolean paymentSuccess = false;

	@Inject
	private UserManager userManager;

	@PostConstruct
	public void init() {
		if (userManager.isSignedIn()) {
			User u = userManager.getCurrentUser();
			shippingName = u.getFirstName() + " " + u.getLastName();
			paymentName = shippingName;
		}
	}

	public void fullfillOrder() {
		setPaymentSuccess(!creditCardNumber.endsWith("00"));
	}

	public String finishOrder() {
		//if(paymentSuccess)
		//	userManager.shopingcart.empty();
		return "finish";
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public CreditCardType getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardType creditCard) {
		this.creditCard = creditCard;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}

	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
