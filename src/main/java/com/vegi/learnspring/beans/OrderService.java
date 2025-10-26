package com.vegi.learnspring.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<String> getCustomerOrders(Long id){
        System.out.println("OrderService: "+customerRepository.hashCode());
        return List.of();
    }


}
