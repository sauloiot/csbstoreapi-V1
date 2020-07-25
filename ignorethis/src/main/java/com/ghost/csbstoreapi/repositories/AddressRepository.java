package com.ghost.csbstoreapi.repositories;
import com.ghost.csbstoreapi.models.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
