package com.ps.ehcache.runner;

import com.ps.ehcache.service.DemoService;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CacheRunner implements CommandLineRunner {
    @Autowired
    private DemoService demoService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("====Begin");
        System.out.println(LocalDateTime.now().toString());
        List<String> nameList = this.demoService.getNameList();
        String result = ReflectionToStringBuilder.toString(nameList);
        System.out.println(result);
        System.out.println("call `1 done.");
        System.out.println(LocalDateTime.now().toString());
        nameList = this.demoService.getNameList();
        System.out.println(ReflectionToStringBuilder.toString(nameList));
        System.out.println("call '2");
        System.out.println(LocalDateTime.now().toString());
    }
}
