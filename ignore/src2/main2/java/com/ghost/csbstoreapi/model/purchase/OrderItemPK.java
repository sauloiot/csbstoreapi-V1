package com.ghost.csbstoreapi.model.purchase;

import com.ghost.csbstoreapi.model.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "buy_order_id")
    private BuyOrder buyOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public BuyOrder getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(BuyOrder buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return buyOrder.equals(that.buyOrder) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyOrder, product);
    }
}
