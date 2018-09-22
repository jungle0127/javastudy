package com.ps.ehcache.demo1.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "instruments")
public class MusicService {
    @CacheEvict(allEntries = true)
    public void clearCache(){}
    @Cacheable(condition = "#instrument.equals('trombone')")
    public String play(String instrument) {
        System.out.println("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }
}
