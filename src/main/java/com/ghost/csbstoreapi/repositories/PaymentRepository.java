package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.models.purchase.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
