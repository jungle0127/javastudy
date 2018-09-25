package com.ps.ehcache.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManagerCheckRunner implements CommandLineRunner {
    @Autowired
    private CacheManager cacheManager;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cacheManager.getClass().getName());
    }
}
