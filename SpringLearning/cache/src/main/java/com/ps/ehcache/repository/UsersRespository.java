package com.ps.ehcache.repository;

import com.ps.ehcache.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRespository extends JpaRepository<Users,Long> {
    Users findByName(String name);
}
