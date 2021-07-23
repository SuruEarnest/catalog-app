package com.omnirio.catalog.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.omnirio.catalog.app.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	Page<Product> findAll(Pageable pageable);
	Optional<Product>findByProductName(String name);
	Page<Product> findByCategoryId(long id,Pageable pageable);
}
