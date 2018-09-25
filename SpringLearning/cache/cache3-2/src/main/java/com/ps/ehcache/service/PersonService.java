package com.ps.ehcache.service;

import com.ps.ehcache.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@CacheDefaults(cacheName = "peopleCache")
public class PersonService {
    @Autowired
    private CacheManager cacheManager;
    private Map<Integer,Person> personMap = new ConcurrentHashMap<>();
    @PostConstruct
    public void initResource(){
        personMap.put(123,new Person(123,"lotus","chen"));
        personMap.put(456,new Person(456,"arbor","zhang"));
    }
    @CacheResult
    public Person getPerson(int ssn) {
        System.out.println(String.format("ssn %s not found in cache. TimeStamp: %s", ssn, LocalDateTime.now().toString()));
        System.out.println(cacheManager.getClass().getName());
        return personMap.get(ssn);
    }
}
