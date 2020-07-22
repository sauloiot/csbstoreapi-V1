package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.model.Category;
import com.ghost.csbstoreapi.model.location.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
