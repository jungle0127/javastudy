package com.ps.ehcache.config;

import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.ExpiryPolicy;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableCaching
public class EhCacheConfig {

    @Bean("cacheManager")
    public CacheManager cacheManager(){
        CacheConfiguration<String,String> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,String.class,
                ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(1000L, EntryUnit.ENTRIES)
                .offheap(100L, MemoryUnit.MB)
                .disk(500L,MemoryUnit.MB,false))
                .withExpiry(ExpiryPolicy.NO_EXPIRY)
                .build();
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence("/var/cache/data"))
                .withCache("defaultCache",cacheConfiguration)
                .build(true);
        return cacheManager;
    }

}
