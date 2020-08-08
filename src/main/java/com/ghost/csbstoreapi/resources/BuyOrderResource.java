package com.ghost.csbstoreapi.resources;

import com.ghost.csbstoreapi.dto.CategoryDTO;
import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ghost.csbstoreapi.services.BuyOrderService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/orders")
public class BuyOrderResource {
	
	@Autowired
	private BuyOrderService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<BuyOrder> find(@PathVariable Integer id) {
		BuyOrder obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody BuyOrder obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
