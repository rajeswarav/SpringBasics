package com.vegi.learnspring.di;

public class LoanRequest {
    Long reqId;
    String personName;
    String personEmail;
    String uniqueId;

    public LoanRequest(){

    }

    public LoanRequest(Long reqId, String personName, String personEmail, String uniqueId) {
        this.reqId = reqId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.uniqueId = uniqueId;
    }

}
