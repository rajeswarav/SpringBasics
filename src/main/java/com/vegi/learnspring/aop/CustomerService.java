package com.vegi.learnspring.aop;

public class CustomerService implements ICustomerService{

    public Customer createCustomer(Customer customer){
        if(customer.id()!=0){
            throw new IllegalArgumentException("Customer id must be greater than 0");
        }
        System.out.println("Customer created");
        return customer;
    }

    public void updateCustomer(Customer customer){
        System.out.println("Customer updated");
    }
}
