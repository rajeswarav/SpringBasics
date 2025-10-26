package com.vegi.learnspring.aop;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //useHandWrittenProxy();
        //useJDKDynamicProxy();
        useCgLibDynamicProxy();
    }

    private static void useCgLibDynamicProxy() {
        PersonService personService = new PersonService();
        TransactionalCglibProxy cglibProxy = new TransactionalCglibProxy();
        PersonService personServiceProxy = cglibProxy.createProxy(personService);

        Person person = new Person();
        personServiceProxy.createPerson(person);


    }

    private static void useJDKDynamicProxy() {
        CustomerService customerService = new CustomerService();
        TransactionJdkProxy<?> proxy = new TransactionJdkProxy<>(customerService);
        ICustomerService customerServiceProxy = (ICustomerService) Proxy
                .newProxyInstance(Main.class.getClassLoader(),
                        new Class[]{ICustomerService.class},
                        proxy);

        Customer customer = new Customer(0L, "Vegi");
        customerServiceProxy.createCustomer(customer);
    }

    static void useHandWrittenProxy() {
        CustomerService customerService = new CustomerService();
        CustomerServiceProxy customerServiceProxy = new CustomerServiceProxy(customerService);
        Customer customer = new Customer(1L,"vegi");
        customerServiceProxy.creaeCustomer(customer);
    }


}
