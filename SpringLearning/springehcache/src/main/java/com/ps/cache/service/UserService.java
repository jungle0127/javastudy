package com.ps.cache.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Cacheable(value = "content")
    public List<String> getUser() {
        List<String> userList = new LinkedList<String>();
        userList.add("ps");
        return userList;
    }

}
