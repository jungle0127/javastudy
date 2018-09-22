package com.ps.ehcache.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * https://www.jb51.net/article/133928.htm      ---detail introduction for ehcache
 * https://memorynotfound.com/spring-boot-ehcache-2-caching-example-configuration/   ----demo
 */

@EnableCaching
@SpringBootApplication
public class CacheApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CacheApplication.class,args);
    }
}
