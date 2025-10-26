package com.vegi.learnspring.aop;

public class PersonService {

    public Person createPerson(Person person){
        System.out.println("create person");
        return person;
    }

    public void updatePerson(Person person){
        System.out.println("update person");
    }
}
