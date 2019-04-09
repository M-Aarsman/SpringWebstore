package com.magda.webstore.service.impl;

import com.magda.webstore.domain.Customer;
import com.magda.webstore.domain.repository.CustomerRepository;
import com.magda.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCostumers() {
        return customerRepository.getAllCustomers();
    }
}
