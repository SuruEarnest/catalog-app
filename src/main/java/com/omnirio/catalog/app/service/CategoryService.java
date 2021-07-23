package com.omnirio.catalog.app.service;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.model.Category;
import com.omnirio.catalog.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public Category findByCategoryId(long id) {
        return categoryRepository.findById(id);
    }

    public Category findById(long id) {
        return categoryRepository.findById(id);
    }

    public Page<Category> findAll(int page, int size) {

        if (page <= 0) {
            throw new BadRequestException("Bad Request!Page index must not be zero or less.");
        }

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
        return categoryRepository.findAll(pageable);
    }
}
