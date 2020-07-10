package com.ghost.csbstoreapi.resources;

import com.ghost.csbstoreapi.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @RequestMapping(method= RequestMethod.GET)
    public List<Category> list() {

        Category cat1 = new Category(1, "informatica");
        Category cat2 = new Category(2, "Escritorio");

        List<Category> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);

        return list;
    }
}