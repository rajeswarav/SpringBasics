package com.vegi.learnspring.beans;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class CustomerService{

    private  final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
       // System.out.println(customerRepository.hashCode());
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    void init(){
        System.out.println("CustomerService: init");
    }

    @PreDestroy
    void  destroy(){
        System.out.println("CustomerService: destroy");
    }

    public Customer getCustomer(Long id){
        System.out.println("CustomerService: "+customerRepository.hashCode());
        return customerRepository.findById(id);
    }

}
