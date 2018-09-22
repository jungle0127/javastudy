package com.ps.ehcache.service;

import com.ps.ehcache.model.Users;
import com.ps.ehcache.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UsersCache {
    @Autowired
    private UsersRespository usersRespository;
    @Cacheable(value = "usercache", key = "#name")
    public Users getUser(String name) {
        return usersRespository.findByName(name);
    }
}
