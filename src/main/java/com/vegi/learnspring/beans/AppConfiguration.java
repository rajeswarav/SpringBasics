package com.vegi.learnspring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    CustomerRepository customerRepository(){
        return new CustomerRepository();
    }

    @Bean
    CustomerService getCustomerService(CustomerRepository customerRepository){
        return new CustomerService(customerRepository);
    }

}
