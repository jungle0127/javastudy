package com.ps.ehcache.controller;

import com.ps.ehcache.model.Users;
import com.ps.ehcache.service.UsersCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    @Autowired
    private UsersCache usersCache;

    @GetMapping("/{name}")
public Users getUser(@PathVariable final String name){
    return usersCache.getUser(name);
}

}
