package com.example.pantrypal.controller;

import com.example.pantrypal.model.Product;
import com.example.pantrypal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product, id);
    }

//    @PatchMapping("/{id}")
//    public Product updateQuantity(@RequestBody @Valid ModifyQuantityRequest modifyQuantityRequest, @PathVariable Long id) {
//        return productService.updateProduct(modifyQuantityRequest, id);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}