package com.omnirio.catalog.app.service;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.exceptions.RecordNotFoundException;
import com.omnirio.catalog.app.model.Category;
import com.omnirio.catalog.app.model.Product;
import com.omnirio.catalog.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        if(category==null){
          throw new BadRequestException("System cannot save null category");
        }
        category.setCreatedDate(LocalDateTime.now());
        category.setLastModifiedDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        if(category.getId()<=0){
            throw new BadRequestException("Please kindly specify valid Id of category to be updated");
        }
        category.setLastModifiedDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public Category findById(long id) {
        Optional<Category> product = categoryRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RecordNotFoundException(String.format("Product with specified '%d' cannot be found", id));
    }

    public Page<Category> findAll(int page, int size) {
        if (page <= 0 || size<=0) {
            throw new BadRequestException("Bad Request!Page index or size must not be zero or less.");
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
        return categoryRepository.findAll(pageable);
    }
}
