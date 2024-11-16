package com.example.pantrypal.service;

import com.example.pantrypal.dto.ModifyProductRequest;
import com.example.pantrypal.exception.CustomException;
import com.example.pantrypal.model.DryProduct;
import com.example.pantrypal.model.FreshProduct;
import com.example.pantrypal.model.Product;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.pantrypal.repository.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product createProduct(Product product) throws CustomException {
        if (product instanceof FreshProduct freshProduct) {
            if (freshProduct.getExpiryDate() != null && freshProduct.getExpiryDate().before(new Date())) {
                throw new CustomException("The expiry date is in the past.");
            }
//            if (freshProduct.getOpenedDate() == null) {
//                freshProduct.setOpenedDate(new Date());
//            }
        }
        else if (product instanceof DryProduct dryProduct) {
            if (dryProduct.getEdible() == null) {
                throw new CustomException("Edible status must be specified for dry products.");
            }
        }
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) throws Exception {
        var product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new CustomException("Product with ID " + id + " not found.");
        }

        Product foundProduct = product.get();

        if (foundProduct instanceof FreshProduct freshProduct) {
            if (freshProduct.isExpired()) {
                throw new CustomException("The product " + freshProduct.getName() + " has expired.");
            }
        }

        return foundProduct;
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
    public Product updateProductFields(Long id, ModifyProductRequest modifyProductRequest) throws CustomException {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new CustomException("Product with ID " + id + " not found.");
        }

        if (modifyProductRequest.getName() != null) {
            product.setName(modifyProductRequest.getName());
//            System.out.println("updated name: " + product.getName());
        }
        if (modifyProductRequest.getDescription() != null) {
            product.setDescription(modifyProductRequest.getDescription());
        }
        if (modifyProductRequest.getPrice() != null && modifyProductRequest.getPrice() >= 0) {
            product.setPrice(modifyProductRequest.getPrice());
        }
        if (modifyProductRequest.getQuantity() != null && modifyProductRequest.getQuantity() > 0) {
            product.setQuantity(modifyProductRequest.getQuantity());
        }
        if (modifyProductRequest.getStoringLocation() != null) {
            product.setStoringLocation(modifyProductRequest.getStoringLocation());
        }

        if (product instanceof FreshProduct freshProduct) {
            if (modifyProductRequest.getExpiryDate() != null) {
                freshProduct.setExpiryDate(modifyProductRequest.getExpiryDate());
            }
//            if (modifyProductRequest.getOpenedDate() != null) {
//                freshProduct.setOpenedDate(modifyProductRequest.getOpenedDate());
//            }
        } else if (product instanceof DryProduct dryProduct) {
            if (modifyProductRequest.getEdible() != null) {
                dryProduct.setEdible(modifyProductRequest.getEdible());
            }
        }

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

    public List<FreshProduct> findExpiredFreshProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<FreshProduct> expiredFreshProducts = new ArrayList<>();
        Date currentDate = new Date();

        for (Product product : allProducts) {
            if (product instanceof FreshProduct freshProduct) {
                // Check if the expiration date is before the current date
                if (freshProduct.getExpiryDate().before(currentDate)) {
                    expiredFreshProducts.add(freshProduct);
                }
            }
        }
        return expiredFreshProducts;
    }

    public List<FreshProduct> findAllFreshProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<FreshProduct> freshProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (product instanceof FreshProduct) {
                freshProducts.add((FreshProduct) product);
            }
        }
        return freshProducts;
    }

    public List<DryProduct> findAllDryProducts(Boolean edibleStatus) {
        List<Product> allProducts = productRepository.findAll();
        List<DryProduct> dryProducts = new ArrayList<>();
        for (Product product : allProducts) {
            if (product instanceof DryProduct dryProduct) {
                if (edibleStatus == null || dryProduct.getEdible() == edibleStatus) {
                    dryProducts.add(dryProduct);
                }
            }
        }
        return dryProducts;
    }
}