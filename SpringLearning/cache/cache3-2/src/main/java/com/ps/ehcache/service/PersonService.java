package com.ps.ehcache.service;

import com.ps.ehcache.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import java.time.LocalDateTime;

@Service
@CacheDefaults(cacheName = "peopleCache")
public class PersonService {
    @Autowired
    private CacheManager cacheManager;
    @CacheResult
    public Person getPerson(int ssn) {
        System.out.println(String.format("ssn %s not found in cache. TimeStamp: %s", ssn, LocalDateTime.now().toString()));
        System.out.println(cacheManager.getClass().getName());
        switch (ssn) {
            case 123456789:
                return new Person(ssn, "Geoff", "Gibson");
            case 987654321:
                return new Person(ssn, "Cory", "Beck");
            default:
                return new Person(ssn,"John","Doe");
        }
    }
}
