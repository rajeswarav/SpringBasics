package com.vegi.learnspring.di;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

public class LoanServiceTest {

    LoanService loanService;
    IBackgroundVerificationService bvService;

    @BeforeEach
    void setUp(){
        bvService = Mockito.mock(IBackgroundVerificationService.class);
        loanService = new LoanService(bvService);
    }


    @Test
    void shouldApproveLoanWhenScoreIsLessThan3(){
        LoanRequest request = new LoanRequest();
        request.uniqueId= "P100";
        given(bvService.getScore("P100")).willReturn(1);
        boolean approved = loanService.applyForLoad(request);
        assertTrue(approved);
    }

    @Test
    void shouldRejectLoanWhenScoreIsGreaterThan3(){
        LoanRequest request = new LoanRequest();
        request.uniqueId= "P100";
        given(bvService.getScore("P100")).willReturn(4);
        boolean approved = loanService.applyForLoad(request);
        assertFalse(approved);
    }
}
