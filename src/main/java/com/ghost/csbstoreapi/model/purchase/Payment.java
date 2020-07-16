package com.ghost.csbstoreapi.model.purchase;



import com.ghost.csbstoreapi.model.enums.StatePayment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private StatePayment statePayment;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Experiment order;

    public Payment() {
    }

    public Payment(Integer id, StatePayment statePayment, Experiment order) {
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

    public Experiment getOrder() {
        return order;
    }

    public void setOrder(Experiment order) {
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
