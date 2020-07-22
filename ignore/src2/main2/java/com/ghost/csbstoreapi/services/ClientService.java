package com.ghost.csbstoreapi.services;


import com.ghost.csbstoreapi.model.user.Client;
import com.ghost.csbstoreapi.repositories.ClientRepository;
import com.ghost.csbstoreapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client find(Integer id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto not found! Id: " + id + ", Type: " + Client.class.getName()));
    }

}
