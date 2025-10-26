package com.vegi.learnspring.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class TransactionalCglibProxy {

    public <T> T createProxy(T object){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(getMethodInterceptor());
        return (T) enhancer.create();

    }

    private MethodInterceptor getMethodInterceptor() {

        return (obj, method, args, proxy) -> {
            try {
                System.out.println("start transaction");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("commit transaction");
                return result;
            } catch (RuntimeException e) {
                System.out.println("rollback transaction");
                throw e;
            }finally {
                System.out.println("close connection");
            }


        };
    }
}
