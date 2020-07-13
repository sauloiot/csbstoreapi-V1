package com.ghost.csbstoreapi.services;

import com.ghost.csbstoreapi.model.Category;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category find(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto not found! Id: " + id + ", Type: " + Category.class.getName()));
    }

}
