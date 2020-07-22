package com.ghost.csbstoreapi.models.purchase;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghost.csbstoreapi.models.enums.StatePayment;
import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import com.ghost.csbstoreapi.models.purchase.Payment;

@Entity
public class PaymentSlip extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date expireDate;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date paymentDate;

	public PaymentSlip() {
	}

	public PaymentSlip(Integer id, StatePayment state, BuyOrder buyOrder, Date expireDate, Date paymentDate) {
		super(id, state, buyOrder);
		this.paymentDate = paymentDate;
		this.expireDate = expireDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}	
	
}
