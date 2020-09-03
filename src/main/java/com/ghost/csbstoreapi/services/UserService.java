package com.ghost.csbstoreapi.services;

import com.ghost.csbstoreapi.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static UserSS authenticated(){
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }

    }
}
