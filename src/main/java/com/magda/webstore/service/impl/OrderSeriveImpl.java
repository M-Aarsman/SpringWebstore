package com.magda.webstore.service.impl;

import com.magda.webstore.domain.Product;
import com.magda.webstore.domain.repository.ProductRepository;
import com.magda.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSeriveImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int count) {
        Product productById = productRepository.
                getProductById(productId);
        if(productById.getUnitsInStock() < count){
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba " +
                    "sztuk w magazynie: "+ productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
