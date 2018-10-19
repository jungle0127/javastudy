package com.ps.ehcache.service;

import com.ps.ehcache.dao.domain.UsersMapper;
import com.ps.ehcache.dao.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;

@Service
@CacheDefaults(cacheName = "peopleCache")
public class UserService {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private UsersMapper usersMapper;
    @CacheResult
    public Users getUser(String loginName){
        System.out.println(cacheManager.getClass().getSimpleName());
        return this.usersMapper.selectByLoginName(loginName);
    }

}
