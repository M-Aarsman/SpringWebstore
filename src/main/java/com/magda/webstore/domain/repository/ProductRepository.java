package com.magda.webstore.domain.repository;

import com.magda.webstore.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);
}
