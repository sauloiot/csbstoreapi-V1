package com.ghost.csbstoreapi.model.purchase;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghost.csbstoreapi.model.Product;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private OrderItemPK orderItemPK = new OrderItemPK();

    private Double discount;
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(BuyOrder buyOrder, Product product, Double discount, Integer quantity, Double price) {
        super();
        orderItemPK.setBuyOrder(buyOrder);
        orderItemPK.setProduct(product);
//        this.orderItemPK = orderItemPK;
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }

    public BuyOrder getBuyOrder() {
        return orderItemPK.getBuyOrder();
    }

    public Product getProduct(){
        return orderItemPK.getProduct();
    }

    public OrderItemPK getOrderItemPK() {
        return orderItemPK;
    }

    public void setOrderItemPK(OrderItemPK orderItemPK) {
        this.orderItemPK = orderItemPK;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemPK.equals(orderItem.orderItemPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemPK);
    }
}
