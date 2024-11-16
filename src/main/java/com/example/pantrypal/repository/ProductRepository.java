package com.example.pantrypal.repository;
import com.example.pantrypal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {

}