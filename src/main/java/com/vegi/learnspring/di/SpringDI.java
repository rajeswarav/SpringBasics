package com.vegi.learnspring.di;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Set;

public class SpringDI {

    public static void main(String[] args) throws Exception {
        //printConstructors(LoanService.class);
        //printConstructors(BackgroundVerificationService.class);
        createBeansUsingReflection();
        
    }

    static void createBeansUsingReflection() throws Exception {
        MockBackgroundVerificationService bvs =(MockBackgroundVerificationService) Class.forName(MockBackgroundVerificationService.class.getName())
                .getDeclaredConstructors()[0].newInstance();
        LoanRepository loanRepository = (LoanRepository) Class.forName(LoanRepository.class.getName())
                .getDeclaredConstructors()[0].newInstance();
        LoanService loanService = (LoanService) Class.forName(LoanService.class.getName())
                .getDeclaredConstructors()[0].newInstance(bvs, loanRepository);

        LoanRequest loanRequest = new LoanRequest(1l,"Rajesh", "rajesh@gmail.com","P100");

        boolean approved = loanService.applyForLoad(loanRequest);
        //System.out.println(approved);
        if(approved){
            System.out.println("loan approved");
        }else{
            System.out.println("loan rejected");
        }


    }
    
    static void printConstructors(Class<?> type){
        Constructor<?>[] declaredConstructors = type.getDeclaredConstructors();
         Parameter[] parameters =declaredConstructors[0].getParameters();

         for (Parameter parameter : parameters) {
             System.out.println("parameterType:"+parameter.getType());
         }
    }


    public static void scanForComonents() {
        ClassPathScanningCandidateComponentProvider scanner  = new ClassPathScanningCandidateComponentProvider(false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(Component.class));

        Set<BeanDefinition>  beanDefinitions = scanner.findCandidateComponents("com.vegi.learnspring.di");
        for(BeanDefinition bd : beanDefinitions){
            System.out.println(bd.getBeanClassName());
        }
    }
}
