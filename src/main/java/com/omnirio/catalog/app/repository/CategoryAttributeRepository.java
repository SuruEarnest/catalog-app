package com.omnirio.catalog.app.repository;

import com.omnirio.catalog.app.model.Category;
import com.omnirio.catalog.app.model.CategoryAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute,Long> {
	Optional<CategoryAttribute> findByCategoryAttributeName(String name);
	Page<CategoryAttribute> findAll(Pageable pageable);
}
