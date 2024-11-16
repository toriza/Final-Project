package com.example.pantrypal.controller;

import com.example.pantrypal.dto.ModifyProductRequest;
import com.example.pantrypal.model.DryProduct;
import com.example.pantrypal.model.FreshProduct;
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

    @GetMapping("/fresh")
    public List<FreshProduct> getFreshProducts() {
        return productService.findAllFreshProducts();
    }

    @GetMapping("/fresh/expired")
    public List<FreshProduct> getExpiredFreshProducts() {
        return productService.findExpiredFreshProducts();
    }

    @GetMapping("/dry")
    public List<DryProduct> getDryProducts() {
        return productService.findAllDryProducts(null);
    }

    @GetMapping("/dry/edible")
    public List<DryProduct> getEdibleDryProducts() {
        return productService.findAllDryProducts(true);
    }

    @GetMapping("/dry/non-edible")
    public List<DryProduct> getNonEdibleDryProducts() {
        return productService.findAllDryProducts(false);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws Exception {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) throws Exception {
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

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product changeQuantity(@RequestBody int quantity, @PathVariable Long id) throws Exception {
        if (quantity >= 0) {
            return productService.addQuantity(id, quantity);
        } else {
            return productService.reduceQuantity(id, Math.abs(quantity));
        }
    }
}