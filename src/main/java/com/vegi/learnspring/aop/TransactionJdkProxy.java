package com.vegi.learnspring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionJdkProxy<T>  implements InvocationHandler{
    private T target;
    public TransactionJdkProxy(T target){
         this.target  = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("start transaction");
            Object result = method.invoke(target, args);
            System.out.println("commit transaction");
            return result;
        }catch (Exception e){
            System.out.println("rollback transaction");
            throw e;
        }finally {
            System.out.println("end connection");
        }

    }
}

