package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.models.location.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
