package com.checkout.flow;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class CheckoutFlow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Produces
	@FlowDefinition
	public Flow defineFlow(@FlowBuilderParameter FlowBuilder builder) {
		builder.id("", "checkout");//com.com.checkout.flow.Checkout

		builder.viewNode("shipping", "/checkout/shipping-details.xhtml").markAsStartNode();
		builder.viewNode("payment", "/checkout/payment-details.xhtml");
		builder.viewNode("review", "/checkout/review-order.xhtml");

		builder.methodCallNode("execute")
			.expression("#{checkout.fullfillOrder}")
			.defaultOutcome("check-result");

		builder.switchNode("check-result")
				.switchCase()
					.condition("#{checkout.paymentSuccess}").
					fromOutcome("success")
				.switchCase()
					.condition("#{not checkout.paymentSuccess}")
					.fromOutcome("failure");
		
		builder.viewNode("success", "/checkout/payment-success.xhtml");
		builder.viewNode("success", "/checkout/payment-failure.xhtml");
		
		builder.returnNode("finish").fromOutcome("home");

		return builder.getFlow();

	}
}
