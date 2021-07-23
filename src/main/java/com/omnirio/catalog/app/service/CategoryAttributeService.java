package com.omnirio.catalog.app.service;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.model.CategoryAttribute;
import com.omnirio.catalog.app.repository.CategoryAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryAttributeService {

    @Autowired
    private CategoryAttributeRepository categoryAttributeRepository;

    public CategoryAttribute save(CategoryAttribute categoryAttribute) {
        return categoryAttributeRepository.save(categoryAttribute);
    }

    public CategoryAttribute findByName(String categoryName) {
        return categoryAttributeRepository.findByName(categoryName);
    }

    public CategoryAttribute findByCategoryId(long id) {
        return categoryAttributeRepository.findById(id);
    }

    public CategoryAttribute findById(long id) {
        return categoryAttributeRepository.findById(id);
    }

    public Page<CategoryAttribute> findAll(int page, int size) {

        if (page <= 0) {
            throw new BadRequestException("Bad Request!Page index must not be zero or less.");
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
        return categoryAttributeRepository.findAll(pageable);
    }
}
