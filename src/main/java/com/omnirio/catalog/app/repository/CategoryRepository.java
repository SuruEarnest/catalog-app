package com.omnirio.catalog.app.repository;

import com.omnirio.catalog.app.model.Category;
import com.omnirio.catalog.app.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
	Optional<Category> findByCategoryName(String name);
	Page<Category> findAll(Pageable pageable);
}
