package com.omnirio.catalog.app.service;

import com.omnirio.catalog.app.exceptions.RecordNotFoundException;
import com.omnirio.catalog.app.repository.ProductRepository;
import com.omnirio.catalog.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.omnirio.catalog.app.exceptions.BadRequestException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        if (product == null) {
            throw new BadRequestException("System cannot accept null for product.");
        }
        product.setCreatedDate(LocalDateTime.now());
        product.setLastModifiedDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product update(Product product) {
        if (product.getId() <= 0) {
            throw new BadRequestException("Please kindly specify valid Id of product to be updated");
        }
        product.setLastModifiedDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Product findByProductName(String name) {
        Optional<Product> product = productRepository.findByProductName(name);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RecordNotFoundException(String.format("Product with name '%s' cannot be found", name));
    }

    public Page<Product> findByCategoryId(long id,int page, int size) {
        if (page <= 0 || size<=0) {
            throw new BadRequestException("Bad Request!Page index or size must not be zero or less.");
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
      return productRepository.findByCategoryId(id,pageable);
    }

    public Product findById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RecordNotFoundException(String.format("Product with specified '%d' cannot be found", id));
    }

    public Page<Product> findAll(int page, int size) {
        if (page <= 0 || size<=0) {
            throw new BadRequestException("Bad Request!Page index or size must not be zero or less.");
        }
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").descending());
        return productRepository.findAll(pageable);
    }
}
