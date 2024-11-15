package com.example.pantrypal.controller;

import com.example.pantrypal.dto.ModifyProductRequest;
import com.example.pantrypal.model.Product;
import com.example.pantrypal.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Valid
@Validated
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws Exception {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) throws Exception {
        return productService.updateProduct(product, id);
    }

    @PatchMapping("/{id}")
    public Product updateProductFields(@RequestBody ModifyProductRequest modifyProductRequest, @PathVariable Long id) throws Exception {
        return productService.updateProductFields(id, modifyProductRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}