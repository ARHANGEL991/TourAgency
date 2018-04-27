package com.tour.security;

import com.tour.model.BaseUser;
import com.tour.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RestUserDetailServiceImpl implements UserDetailsService {

    private final BaseUserRepository userRepository;

    @Autowired
    public RestUserDetailServiceImpl(BaseUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        BaseUser user = userRepository.findByUserName(username);

        if (user == null) throw new UsernameNotFoundException(username + " not found");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (BaseUser.Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }


}