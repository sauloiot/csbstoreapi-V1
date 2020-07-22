package com.ghost.csbstoreapi.resources;

import com.ghost.csbstoreapi.model.Category;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import com.ghost.csbstoreapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {


    @Autowired
    private CategoryService service;

//    @RequestMapping(method= RequestMethod.GET)
//    public List<Category> list() {
//
//        Category cat1 = new Category(1, "informatica");
//        Category cat2 = new Category(2, "Escritorio");
//
//        List<Category> list = new ArrayList<>();
//        list.add(cat1);
//        list.add(cat2);
//
//        return list;
//    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Category obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }
}