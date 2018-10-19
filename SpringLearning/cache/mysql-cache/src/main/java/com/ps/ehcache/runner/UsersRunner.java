package com.ps.ehcache.runner;

import com.ps.ehcache.dao.model.Users;
import com.ps.ehcache.service.UserService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsersRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("==================================================");
        Users user = userService.getUser("ps");
        System.out.println(ReflectionToStringBuilder.toString(user));
        System.out.println("==================================================");
        user = userService.getUser("ps");
        System.out.println(ReflectionToStringBuilder.toString(user));
        System.out.println("==================================================");
    }
}
