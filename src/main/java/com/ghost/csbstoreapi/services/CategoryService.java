package com.ghost.csbstoreapi.services;

import java.util.Optional;

import com.ghost.csbstoreapi.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Category insert(Category obj){
		obj.setId(null);
		return repo.save(obj);
	}

	public Category update(Category obj){
	    find(obj.getId());
	    return repo.save(obj);
    }

    public void delete(Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("You cannot delete a category with associated products");
		}


	}
}
