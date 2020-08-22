package com.ghost.csbstoreapi.services;

import com.ghost.csbstoreapi.models.user.Client;
import com.ghost.csbstoreapi.repositories.ClientRepository;
import com.ghost.csbstoreapi.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client cli = repo.findByEmail(email);

        if (cli == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(cli.getId(), cli.getEmail(), cli.getPassword(), cli.getProfile());
    }
}
