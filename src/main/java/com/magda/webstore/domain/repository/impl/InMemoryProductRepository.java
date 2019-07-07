package com.magda.webstore.domain.repository.impl;

import com.magda.webstore.domain.Product;
import com.magda.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem "+
                "o rozdzielczości 6401136 i 8-megapikselowym aparatem");
        iphone.setCategory("Smartfon");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem " +
                "Intel Core 3.generacji");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym " +
                "tabletem z 4-rdzeniowym procesorem Qualcomm SnapdragonTM S4 Pro");
                tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    public Product getProductById(String productId) {
        Product productById = null;
        for(Product product : listOfProducts) {
            if(product!=null && product.getProductId()!=null &&
                    product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }
        if(productById == null){
            throw new IllegalArgumentException("Brak produktu o wskazanym id: " +
                    ""+ productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();

        for (Product product : listOfProducts) {
            if(product.getCategory().equalsIgnoreCase(category)) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();

        if(criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }

        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;

    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<Product>();

        for (Product product : listOfProducts) {
            if(product.getManufacturer().equalsIgnoreCase(manufacturer)) {
                productsByManufacturer.add(product);
            }
        }

        return productsByManufacturer;
    }

    @Override
    public List<Product> getProductsByPriceFilter(Map<String, String> priceRange, String manufacturer, String productCategory) {
        List<Product> productsByPrice = new ArrayList<>();
        List<Product> productByManufacturer = getProductsByManufacturer(manufacturer);
        List<Product> productByCategory = getProductsByCategory(productCategory);

        for (Product product : listOfProducts) {
            if (product.getUnitPrice().compareTo(BigDecimal.valueOf(Integer.valueOf(priceRange.get("low")))) >= 0
                && product.getUnitPrice().compareTo(BigDecimal.valueOf(Integer.valueOf(priceRange.get("high")))) <= 0) {
                productsByPrice.add(product);
            }
        }

        productsByPrice.retainAll(productByCategory);
        productsByPrice.retainAll(productByManufacturer);

        return productsByPrice;
    }
}
