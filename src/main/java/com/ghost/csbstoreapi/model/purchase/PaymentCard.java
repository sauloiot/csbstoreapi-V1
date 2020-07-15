package com.ghost.csbstoreapi.model.purchase;

import com.ghost.csbstoreapi.model.enums.StatePayment;

public class PaymentCard extends Payment{
    private static final long serialVersionUID = 1L;
    private Integer portionNumber;

    public PaymentCard() {
    }

    public PaymentCard(Integer id, StatePayment statePayment, Order order, Integer portionNumber) {
        super(id, statePayment, order);
        this.portionNumber = portionNumber;
    }

    public Integer getPortionNumber() {
        return portionNumber;
    }

    public void setPortionNumber(Integer portionNumber) {
        this.portionNumber = portionNumber;
    }
}
