package com.ghost.csbstoreapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
}
