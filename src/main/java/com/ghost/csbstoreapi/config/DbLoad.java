package com.ghost.csbstoreapi.config;

import com.ghost.csbstoreapi.model.Category;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile({"test"})
public class DbLoad implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "INFORMATICA");
        Category cat2 = new Category(null, "ESCRITORIO");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));

    }
}
