package com.vegi.learnspring.di;

import org.springframework.stereotype.Component;

@Component
public class BackgroundVerificationService implements IBackgroundVerificationService {

    public int getScore(String personUniqueId){
        return 2;
    }
}
