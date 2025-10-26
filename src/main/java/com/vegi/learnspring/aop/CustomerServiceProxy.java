package com.vegi.learnspring.aop;

public class CustomerServiceProxy {

    private final   CustomerService delegate;
    public CustomerServiceProxy(CustomerService delegate){
        this.delegate = delegate;
    }

    public Customer creaeCustomer(Customer customer){
        Customer result = null;
        try{
            System.out.println("start transaction..");
            result = delegate.createCustomer(customer);
            System.out.println("commit  transaction..");
        } catch (RuntimeException e) {
            System.out.println("rollback transaction..");
            throw e;
        }finally {
            System.out.println("close connection..");
        }
        return result;
    }

    public void updateCustomer(Customer customer){
        try{
            System.out.println("start transaction..");
            delegate.updateCustomer(customer);
            System.out.println("commit  transaction..");
        } catch (RuntimeException e) {
            System.out.println("rollback transaction..");
            throw e;
        }finally {
            System.out.println("close connection..");
        }
    }
}
