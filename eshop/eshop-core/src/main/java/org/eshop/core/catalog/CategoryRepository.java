package org.eshop.core.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import org.eshop.core.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByName(String name);

}
