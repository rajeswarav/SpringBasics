package com.vegi.learnspring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.vegi.learnspring.di");
        LoanService loanService = context.getBean(LoanService.class);

        LoanRequest loanRequest = new LoanRequest(1l,"Rajesh", "rajesh@gmail.com","P100");

        boolean approved = loanService.applyForLoad(loanRequest);
        //System.out.println(approved);
        if(approved){
            System.out.println("loan approved");
        }else{
            System.out.println("loan rejected");
        }

    }
}
