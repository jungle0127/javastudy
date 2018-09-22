package com.ps.ehcache.controller;

import com.ps.ehcache.pojo.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class GreetingController {
    private Map<String, Greeting> greetingMap = new HashMap<>();
    @Autowired
    private CacheManager cacheManager;
    @PostConstruct
    public void initializeObject(){
        Greeting greeting = new Greeting();
        greeting.setId("1");
        greeting.setMesage("Welcome");
        greetingMap.put(greeting.getId(),greeting);
        greeting = new Greeting();
        greeting.setId("2");
        greeting.setMesage("Hello");
        greetingMap.put(greeting.getId(),greeting);
    }
    @GetMapping("/greeting")
    @Cacheable(value = "cacheName")
    public Collection<Greeting> getGreetings(){
        System.out.println(cacheManager.getClass().getName());
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return greetingMap.values();
    }
    @GetMapping("/evict")
    @CacheEvict(value = "cacheName")
    public String evictCache(){
        return "Cache is cleared.";
    }
}
