package com.omnirio.catalog.app.service;

import java.util.List;
import com.omnirio.catalog.app.repository.ProductRepository;
import com.omnirio.catalog.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.omnirio.catalog.app.exceptions.BadRequestException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product customer) {
        return productRepository.save(customer);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product findByCategoryName(String categoryName) {
        return productRepository.findByName(categoryName);
    }

    public Product findByCategoryId(long id) {
        return productRepository.findById(id);
    }

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public Page<Product> findAll(int page, int size) {
        if (page <= 0) {
            throw new BadRequestException("Bad Request!Page index must not be zero or less.");
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
        return productRepository.findAll(pageable);
    }
}
