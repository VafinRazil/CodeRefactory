package com.rvafin.springjwt.security.services;

import com.rvafin.springjwt.models.User;
import com.rvafin.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getAuthenticateUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return userRepository.findByUsername(userDetails.getUsername());
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
