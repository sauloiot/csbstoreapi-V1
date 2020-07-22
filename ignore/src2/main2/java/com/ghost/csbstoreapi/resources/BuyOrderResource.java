package com.ghost.csbstoreapi.resources;


import com.ghost.csbstoreapi.model.purchase.BuyOrder;
import com.ghost.csbstoreapi.repositories.BuyOrderRepository;
import com.ghost.csbstoreapi.services.BuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buyorders")
public class BuyOrderResource {


    @Autowired
    private BuyOrderService service;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        BuyOrder obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }
}