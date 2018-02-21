package org.eshop.core.catalog;

import org.eshop.core.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findByName(String name);

}
