package com.ghost.csbstoreapi.model.purchase;

import com.ghost.csbstoreapi.model.user.Address;
import com.ghost.csbstoreapi.model.user.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class BuyOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "buyOrder")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JoinColumn(name = "address_delivery_id")
//    @ManyToOne
    @OneToOne
    private Address address;

    public BuyOrder() {
    }

    public BuyOrder(Integer id, Date instant, Payment payment, Client client, Address address) {
        super();
        this.id = id;
        this.instant = instant;
        this.payment = payment;
        this.client = client;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyOrder buyOrder = (BuyOrder) o;
        return id.equals(buyOrder.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
