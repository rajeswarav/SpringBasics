package com.vegi.learnspring.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("com.vegi.learnspring.beans");

    CustomerService customerService = context.getBean(CustomerService.class);
    Customer customer = customerService.getCustomer(1L);
        System.out.println(customer);



    }
}
