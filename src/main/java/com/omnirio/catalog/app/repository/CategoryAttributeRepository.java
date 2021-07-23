package com.omnirio.catalog.app.repository;

import com.omnirio.catalog.app.model.CategoryAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute,Long> {
	CategoryAttribute findByName(String name);
	CategoryAttribute findById(long id);
	Page<CategoryAttribute> findAll(Pageable pageable);
}
