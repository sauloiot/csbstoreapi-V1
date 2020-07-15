package com.ghost.csbstoreapi.model.purchase;

import com.ghost.csbstoreapi.model.enums.StatePayment;

import java.util.Date;

public class PaymentSlip extends Payment{
    private static final long serialVersionUID = 1L;
    private Date expireDate;
    private Date paymentDate;

    public PaymentSlip() {
    }

    public PaymentSlip(Integer id, StatePayment statePayment, Order order, Date expireDate, Date paymentDate) {
        super(id, statePayment, order);
        this.expireDate = expireDate;
        this.paymentDate = paymentDate;
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
