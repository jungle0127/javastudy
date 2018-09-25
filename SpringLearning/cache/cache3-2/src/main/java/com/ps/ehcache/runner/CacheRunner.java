package com.ps.ehcache.runner;

import com.ps.ehcache.pojo.Person;
import com.ps.ehcache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CacheRunner implements CommandLineRunner {
    @Autowired
    private PersonService personService;
    @Override
    public void run(String... args) throws Exception {
        Person person = personService.getPerson(123);
        System.out.println(person.toString());
        System.out.println("Called again");
        personService.getPerson(123);
        System.out.println(person.toString());
        System.out.println("==========================================");
        System.out.println(personService.getPerson(456));
        System.out.println(personService.getPerson(456));
    }
}
