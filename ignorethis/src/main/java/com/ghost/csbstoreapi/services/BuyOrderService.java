package com.ghost.csbstoreapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import com.ghost.csbstoreapi.repositories.BuyOrderRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;

@Service
public class BuyOrderService {
	
	@Autowired
	private BuyOrderRepository repo;
	
	public BuyOrder find(Integer id) {
		Optional<BuyOrder> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto not found! Id: " + id + ", Type: " + BuyOrder.class.getName()));
	}

}
