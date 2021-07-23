package com.omnirio.catalog.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omnirio.catalog.app.model.Product;
import org.springframework.data.domain.Pageable;



@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	Product findByProductId(long id);
	Page<Product> findAll(Pageable pageable);
	Product findByProductName(String name);
	Product findByCategoryId(long id);
	Product findByCategoryName(String  name);
}
