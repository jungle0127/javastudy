package com.ps.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

//@Service
public class LoaderService {
//    @Autowired
//    private UsersRespository usersRespository;

    @PostConstruct
    public void load(){
//        List<Users> usersList = getList();
//        usersRespository.saveAll(usersList);
    }

//    private List<Users> getList() {
//        List<Users> usersList = new LinkedList<>();
//        usersList.add(new Users("ps","arbor",1L));
//        usersList.add(new Users("lotus","arbor",2L));
//        return usersList;
//    }
}
