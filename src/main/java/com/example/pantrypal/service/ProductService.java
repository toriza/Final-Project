package com.example.pantrypal.service;

import com.example.pantrypal.dto.ModifyProductRequest;
import com.example.pantrypal.model.Product;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.pantrypal.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

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


    public Product findById(Long id) throws Exception {
        var product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new Exception(id.toString());
        }
        return product.get();

    }

    @Transactional
    public Product updateProduct(Product productToUpdate, Long id) throws Exception {
        var product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new Exception(id.toString());
        }

        productToUpdate.setId(id);
        return productRepository.save(productToUpdate);
    }

    @Transactional
    public Product updateProductFields(Long id, ModifyProductRequest modifyProductRequest) throws Exception {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new Exception(id.toString());
        }

        if (modifyProductRequest.getName() != null) {
            product.setName(modifyProductRequest.getName());
            System.out.println("updated name: " + product.getName());
        }
        if (modifyProductRequest.getDescription() != null) {
            product.setDescription(modifyProductRequest.getDescription());
        }
        if (modifyProductRequest.getPrice() >= 0) {
            product.setPrice(modifyProductRequest.getPrice());
        }
        if (modifyProductRequest.getQuantity() >= 0) {
            product.setQuantity(modifyProductRequest.getQuantity());
        }
        if (modifyProductRequest.getStoringLocation() != null) {
            product.setStoringLocation(modifyProductRequest.getStoringLocation());
        }
        System.out.println("Heloouuu");
        System.out.println(product);
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Product addQuantity (Long id, int quantityToAdd) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw new Exception(id.toString());
        }

        Product product = productOptional.get();

        product.addQuantity(quantityToAdd);

        return productRepository.save(product);
    }

    @Transactional
    public Product reduceQuantity (Long id, int quantityToAdd) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw new Exception(id.toString());
        }

        Product product = productOptional.get();

        product.reduceQuantity(quantityToAdd);

        return productRepository.save(product);
    }

}