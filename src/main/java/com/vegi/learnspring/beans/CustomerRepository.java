package com.vegi.learnspring.beans;

import org.springframework.stereotype.Repository;

//@Repository
public class CustomerRepository {

    public Customer findById(Long id) {
        return new Customer(1L, "Vegi", "vegi@gmail.com");
    }

}
