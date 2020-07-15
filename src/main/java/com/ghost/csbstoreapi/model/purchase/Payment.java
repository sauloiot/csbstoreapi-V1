package com.ghost.csbstoreapi.model.purchase;

import com.ghost.csbstoreapi.model.enums.StatePayment;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private StatePayment statePayment;

    private Order order;

    public Payment() {
    }

    public Payment(Integer id, StatePayment statePayment, Order order) {
        super();
        this.id = id;
        this.statePayment = statePayment;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatePayment getStatePayment() {
        return statePayment;
    }

    public void setStatePayment(StatePayment statePayment) {
        this.statePayment = statePayment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
