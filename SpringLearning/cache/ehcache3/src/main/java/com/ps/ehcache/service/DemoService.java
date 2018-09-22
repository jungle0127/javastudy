package com.ps.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
//@CacheDefaults(cacheName = "SSAccountInfo")
@CacheConfig(cacheNames = "cachename")
public class DemoService {
    @Autowired
    private CacheManager cacheManager;

    private List<String> nameList = new LinkedList<>();
    @PostConstruct
    public void init(){
        nameList.add("ps");
        nameList.add("lotus");
    }
    @Cacheable
//    @CacheResult
    public List<String> getNameList() throws InterruptedException {
        System.out.println(cacheManager.getClass().getName());
        TimeUnit.SECONDS.sleep(5L);
        return nameList;
    }
}
