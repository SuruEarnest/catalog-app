package com.omnirio.catalog.app.service;

import com.omnirio.catalog.app.exceptions.BadRequestException;
import com.omnirio.catalog.app.exceptions.RecordNotFoundException;
import com.omnirio.catalog.app.model.CategoryAttribute;
import com.omnirio.catalog.app.model.Product;
import com.omnirio.catalog.app.repository.CategoryAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryAttributeService {

    @Autowired
    private CategoryAttributeRepository categoryAttributeRepository;

    public CategoryAttribute create(CategoryAttribute categoryAttribute) {
        if(categoryAttribute==null){
           throw new BadRequestException("System cannot accept null value for category attribute");
        }
        categoryAttribute.setCreatedDate(LocalDateTime.now());
        categoryAttribute.setLastModifiedDate(LocalDateTime.now());
        return categoryAttributeRepository.save(categoryAttribute);
    }

    public CategoryAttribute update(CategoryAttribute categoryAttribute) {
        if(categoryAttribute.getId()<=0){
         throw new BadRequestException("Please specify a valid Id for category attribute.");
        }
        categoryAttribute.setLastModifiedDate(LocalDateTime.now());
        return categoryAttributeRepository.save(categoryAttribute);
    }

    public CategoryAttribute findById(long id) {
        Optional<CategoryAttribute> categoryAttribute =  categoryAttributeRepository.findById(id);
        if (categoryAttribute.isPresent()) {
            return categoryAttribute.get();
        }
        throw new RecordNotFoundException(String.format("Product with specified '%d' cannot be found", id));
    }

    public Page<CategoryAttribute> findAll(int page, int size) {
        if (page <= 0 || size<=0) {
            throw new BadRequestException("Bad Request!Page index or size must not be zero or less.");
        }

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
        return categoryAttributeRepository.findAll(pageable);
    }
}
