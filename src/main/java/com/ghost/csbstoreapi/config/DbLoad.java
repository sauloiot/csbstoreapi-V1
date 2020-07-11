package com.ghost.csbstoreapi.config;

import com.ghost.csbstoreapi.model.Category;
import com.ghost.csbstoreapi.model.Product;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import com.ghost.csbstoreapi.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "INFORMATICA");
        Category cat2 = new Category(null, "ESCRITORIO");

        Product prod1 = new Product(null, "Computador", 2000.0);
        Product prod2 = new Product(null, "Impressora", 800.0);
        Product prod3 = new Product(null, "Mouse", 150.0);

        cat1.getProducts().addAll((Arrays.asList(prod1,prod2,prod3)));
        cat2.getProducts().addAll((Arrays.asList(prod2)));

        prod1.getCategories().addAll(Arrays.asList(cat1));
        prod2.getCategories().addAll(Arrays.asList(cat1,cat2));
        prod3.getCategories().addAll(Arrays.asList(cat1));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(prod1,prod2,prod3));


    }
}
