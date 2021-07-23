package com.omnirio.catalog.app.repository;

import com.omnirio.catalog.app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
	Category findByCategoryId(long id);
	Category findByCategoryName(String name);
	Page<Category> findAll(Pageable pageable);
}
