package com.ghost.csbstoreapi.models.purchase;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ghost.csbstoreapi.models.enums.StatePayment;
import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import com.ghost.csbstoreapi.models.purchase.Payment;

@Entity
@JsonTypeName("paymentCard")
public class PaymentCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer portionNumber;
	
	public PaymentCard() {
	}

	public PaymentCard(Integer id, StatePayment state, BuyOrder buyOrder, Integer portionNumber) {
		super(id, state, buyOrder);
		this.portionNumber = portionNumber;
	}

	public Integer getPortionNumber() {
		return portionNumber;
	}

	public void setPortionNumber(Integer portionNumber) {
		this.portionNumber = portionNumber;
	}
	
	
		
}
