package com.magda.webstore.domain;

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private Integer noOfOrdersMade;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.noOfOrdersMade = 0;
    }

    public Integer getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(Integer noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
