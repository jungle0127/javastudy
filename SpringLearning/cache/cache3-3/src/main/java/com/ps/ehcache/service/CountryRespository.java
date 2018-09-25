package com.ps.ehcache.service;

import com.ps.ehcache.pojo.Country;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@CacheConfig(cacheNames = "countries")
public class CountryRespository {
    private Country pojo;
    @PostConstruct
    public void init(){
        pojo = new Country("T");
        pojo.setAlias("INIT");
    }
    @Cacheable
    public Country findByCode(String code) {
        System.out.println("---> Loading country with code '" + code + "'");
        pojo.setAlias(code);
        return pojo;
    }
    @CachePut
    public void remove(String code){
        pojo.setAlias(code);
        System.out.println("---------updated-----------------");
    }
    @CacheEvict(allEntries = true)
    public void evict(){
        System.out.println("===========evicted===================");
    }

}
