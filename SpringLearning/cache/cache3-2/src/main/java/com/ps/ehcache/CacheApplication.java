package com.ps.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// https://blog.csdn.net/u011410529/article/details/78733497
@SpringBootApplication
@EnableCaching
public class CacheApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CacheApplication.class,args);
    }
}
