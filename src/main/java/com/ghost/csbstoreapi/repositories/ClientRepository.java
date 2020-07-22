package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.models.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
