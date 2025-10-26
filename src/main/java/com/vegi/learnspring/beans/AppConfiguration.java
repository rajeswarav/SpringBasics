package com.vegi.learnspring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    CustomerRepository customerRepository(){
        return new CustomerRepository();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    CustomerService getCustomerService(CustomerRepository customerRepository){
        return new CustomerService(customerRepository);
    }

}
