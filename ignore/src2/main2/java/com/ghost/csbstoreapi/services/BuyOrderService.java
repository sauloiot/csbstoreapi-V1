package com.ghost.csbstoreapi.services;


import com.ghost.csbstoreapi.model.purchase.BuyOrder;
import com.ghost.csbstoreapi.repositories.BuyOrderRepository;

import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyOrderService {

    @Autowired
    private BuyOrderRepository repository;

    public BuyOrder find(Integer id) {
        Optional<BuyOrder> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto not found! Id: " + id + ", Type: " + BuyOrder.class.getName()));
    }

}
