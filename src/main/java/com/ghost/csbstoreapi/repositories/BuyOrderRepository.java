package com.ghost.csbstoreapi.repositories;



import com.ghost.csbstoreapi.model.purchase.BuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyOrderRepository extends JpaRepository<BuyOrder, Integer> {
}
