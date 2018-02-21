package org.eshop.core.catalog;

import java.util.List;

import javax.transaction.Transactional;

import org.eshop.core.entities.Category;
import org.eshop.core.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CatalogService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}

}
