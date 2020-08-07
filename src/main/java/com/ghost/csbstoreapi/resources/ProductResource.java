package com.ghost.csbstoreapi.resources;

import com.ghost.csbstoreapi.dto.ATAProductDTO;
import com.ghost.csbstoreapi.models.Product;
import com.ghost.csbstoreapi.resources.utils.ATAURLUtil;
import com.ghost.csbstoreapi.services.ATAProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ATAProductResource {

	@Autowired
	private ATAProductService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable Integer id) {
		Product obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ATAProductDTO>> findPage(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categories", defaultValue = "") String categories,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String decodedName = ATAURLUtil.decodeParam(name);
		List<Integer> ids = ATAURLUtil.decodeIntList(categories);
		Page<Product> list = service.search(decodedName, ids, page, linesPerPage, orderBy, direction);
		Page<ATAProductDTO> listDto = list.map(obj -> new ATAProductDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
