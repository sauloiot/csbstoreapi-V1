package com.ghost.csbstoreapi.model.purchase;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghost.csbstoreapi.model.user.Address;
import com.ghost.csbstoreapi.model.user.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class BuyOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "buyOrder")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JoinColumn(name = "address_delivery_id")
    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "orderItemPK.buyOrder")
    private Set<OrderItem> orderItemSet = new HashSet<>();

    public BuyOrder() {
    }

    public BuyOrder(Integer id, Date instant, Client client, Address address) {
        super();
        this.id = id;
        this.instant = instant;
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

    //ORDER ITEM
    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
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
