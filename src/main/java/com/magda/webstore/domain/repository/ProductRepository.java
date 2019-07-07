package com.magda.webstore.domain.repository;

import com.magda.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List <Product> getProductsByManufacturer(String manufacturer);

    List<Product> getProductsByPriceFilter(Map<String, String> priceRange, String manufacturer, String productCategory);
}