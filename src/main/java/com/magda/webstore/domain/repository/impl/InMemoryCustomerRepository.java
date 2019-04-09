package com.magda.webstore.domain.repository.impl;

import com.magda.webstore.domain.Customer;
import com.magda.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer Adam = new Customer("1", "Adam", "address1");
        Adam.setNoOfOrdersMade(10);

        Customer Ewa = new Customer("3", "Ewa", "address1");
        Ewa.setNoOfOrdersMade(15);

        listOfCustomers.add(Adam);
        listOfCustomers.add(Ewa);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
