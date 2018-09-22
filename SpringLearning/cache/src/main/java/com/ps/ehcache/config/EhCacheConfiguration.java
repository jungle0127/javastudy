package com.ps.ehcache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ps.ehcache.repository")
@Configuration
@EnableCaching
public class EhCacheConfiguration {
    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(cacheManagerFactoryBean().getObject());
    }
    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactoryBean(){
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache/ehcache.xml"));
        bean.setShared(true);
        return bean;
    }
}
