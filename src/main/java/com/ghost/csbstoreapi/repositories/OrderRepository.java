package com.ghost.csbstoreapi.repositories;



import com.ghost.csbstoreapi.model.purchase.Experiment;
import com.ghost.csbstoreapi.model.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Experiment, Integer> {
}