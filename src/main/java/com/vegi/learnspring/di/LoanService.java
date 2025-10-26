package com.vegi.learnspring.di;

import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private IBackgroundVerificationService bvService;
    private LoanRepository loanRepository;
    LoanService(IBackgroundVerificationService bvService, LoanRepository loanRepository) {
        this.bvService = bvService;
        this.loanRepository = loanRepository;

    }
    public boolean applyForLoad(LoanRequest loanRequest) {
        int score = bvService.getScore(loanRequest.uniqueId);
        if(score < 3){
            System.out.println("sanction loan");
            return true;
        }else{
            System.out.println("Reject loan poor credibility score");
            return false;
        }
    }
}
