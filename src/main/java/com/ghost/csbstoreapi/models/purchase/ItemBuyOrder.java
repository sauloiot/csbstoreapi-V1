package com.ghost.csbstoreapi.models.purchase;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghost.csbstoreapi.models.Product;

@Entity
public class ItemBuyOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemBuyOrderPK id = new ItemBuyOrderPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public ItemBuyOrder() {
	}

	public ItemBuyOrder(BuyOrder buyOrder, Product product, Double discount, Integer quantity, Double price) {
		super();
		id.setBuyOrder(buyOrder);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}

	public double getSubTotal(){
		return (price - discount) * quantity;
	}

	@JsonIgnore
	public BuyOrder getBuyOrder() {
		return id.getBuyOrder();
	}

	public void setBuyOrder(BuyOrder buyOrder){
		id.setBuyOrder(buyOrder);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product){
		id.setProduct(product);
	}
	
	public ItemBuyOrderPK getId() {
		return id;
	}

	public void setId(ItemBuyOrderPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		ItemBuyOrder other = (ItemBuyOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		final StringBuffer sb = new StringBuffer("ItemBuyOrder{");
		sb.append(getProduct().getName());
		sb.append(", Quantity: ");
		sb.append(getQuantity());
		sb.append(", Unity price: ");
		sb.append(nf.format(getPrice()));
		sb.append(", Subtotal: ");
		sb.append(nf.format(getSubTotal()));
		sb.append("\n");
		return sb.toString();
	}
}
