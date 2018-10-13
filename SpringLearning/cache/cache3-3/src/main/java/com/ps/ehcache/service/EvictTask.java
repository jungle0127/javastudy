package com.ps.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class EvictTask {
    @Autowired
    private CountryRespository countryRespository;

    @Scheduled(fixedDelay = 8000)
    public void runTask(){
        this.countryRespository.remove("CODE");
    }
}
