package com.ghost.csbstoreapi.services;

import com.ghost.csbstoreapi.models.Category;
import com.ghost.csbstoreapi.models.Product;
import com.ghost.csbstoreapi.repositories.CategoryRepository;
import com.ghost.csbstoreapi.repositories.ATAProductRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ATAProductService {
	
	@Autowired
	private ATAProductRepository repo;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto not found! Id: " + id + ", Type: " + Product.class.getName()));
	}

	public Page<Product> search(String name, List<Integer> ids,Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy);
		List<Category> categories = categoryRepository.findAllById(ids);
		return repo.findDistinctByNameContainingAndCategoriesIn(name,categories, pageRequest );

}
}
