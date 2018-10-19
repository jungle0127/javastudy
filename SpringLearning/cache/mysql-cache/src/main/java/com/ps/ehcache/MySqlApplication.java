package com.ps.ehcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages= {"com.ps.ehcache.dao.domain"})
public class MySqlApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MySqlApplication.class,args);
    }
}

