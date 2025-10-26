package com.vegi.learnspring.beans;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class CustomerService{

    private  final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id);
    }

}
