package com.vegi.learnspring.template;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo {

    JdbcTemplate jdbcTemplate;
    public JDBCTemplateDemo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void createCustomer(Customer customer) {
        jdbcTemplate.update("insert into Customer(id,name) values (?,?)",
                new Object[]{customer.id(),customer.name()});

    }

    void updateCustomer(Customer customer) {
        jdbcTemplate.update("update customers set name = ? where id=?", customer.name(), customer.id());

    }

}
