package com.ghost.csbstoreapi.models.purchase;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.models.user.Address;

@Entity
public class BuyOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instant;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="buyOrder")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="address_delivery_id")
	private Address addressDelivery;

	@OneToMany(mappedBy="id.buyOrder")
	private Set<ItemBuyOrder> orderItemSet = new HashSet<>();

	public BuyOrder() {
	}

	public BuyOrder(Integer id, Date instant, Client client, Address addressDelivery) {
		super();
		this.id = id;
		this.instant = instant;
		this.client = client;
		this.addressDelivery = addressDelivery;
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
		return addressDelivery;
	}

	public void setAddress(Address addressDelivery) {
		this.addressDelivery = addressDelivery;
	}

	public Set<ItemBuyOrder> getOrderItemSet() {
		return orderItemSet;
	}

	public void setOrderItemSet(Set<ItemBuyOrder> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuyOrder other = (BuyOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
