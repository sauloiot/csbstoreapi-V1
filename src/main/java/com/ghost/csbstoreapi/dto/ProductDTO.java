package com.ghost.csbstoreapi.dto;

import com.ghost.csbstoreapi.models.Product;

import java.io.Serializable;

public class ATAProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Double price;

    public ATAProductDTO() {
    }

    public ATAProductDTO(Product obj){
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
