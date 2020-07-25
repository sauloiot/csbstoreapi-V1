package com.ghost.csbstoreapi.resources;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ghost.csbstoreapi.services.BuyOrderService;

@RestController
@RequestMapping(value="/orders")
public class BuyOrderResource {
	
	@Autowired
	private BuyOrderService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		BuyOrder obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
