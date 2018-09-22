package com.ps.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * this demo1 from :
 * https://www.youtube.com/watch?v=2XryHTbORWY
 */

@SpringBootApplication
@EnableCaching
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
