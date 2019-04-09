package com.magda.webstore.domain.repository;

import com.magda.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}
