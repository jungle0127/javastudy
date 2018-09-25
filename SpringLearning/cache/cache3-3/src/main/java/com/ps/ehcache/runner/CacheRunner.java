package com.ps.ehcache.runner;

import com.ps.ehcache.pojo.Country;
import com.ps.ehcache.service.CountryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CacheRunner implements CommandLineRunner{
    @Autowired
    private CountryRespository countryRespository;

    @Override
    public void run(String... args) throws Exception {
        Country country = countryRespository.findByCode("CD");
        System.out.println(country.toString());
        country = countryRespository.findByCode("CD");
        System.out.println(country.toString());
    }
}
