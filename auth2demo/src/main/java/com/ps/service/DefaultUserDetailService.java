package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public class DefaultUserDetailService implements UserDetailsService {
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = this.passwordEncoder.encode("lotus");
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("adimin,ROLE_USER"));
    }
}
