package com.ghost.csbstoreapi.model.purchase;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghost.csbstoreapi.model.enums.StatePayment;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentSlip extends Payment{
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date expireDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date paymentDate;

    public PaymentSlip() {
    }

    public PaymentSlip(Integer id, StatePayment statePayment, BuyOrder buyOrder, Date expireDate, Date paymentDate) {
        super(id, statePayment, buyOrder);
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
