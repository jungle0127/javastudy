package com.ps.config;

import com.ps.service.DefaultUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class BeanConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        return new DefaultUserDetailService();
    }
}
