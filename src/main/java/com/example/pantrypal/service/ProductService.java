package com.example.pantrypal.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.pantrypal.model.Product;
import org.springframework.stereotype.Service;
import com.example.pantrypal.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
    @Transactional

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public Product updateProduct(Product productToUpdate, Long id) {
        var product = productRepository.findById(id);

        if (product.isEmpty()) {
            return null;
        }
        productToUpdate.setId(id);
        return productRepository.save(productToUpdate);
    }



    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
