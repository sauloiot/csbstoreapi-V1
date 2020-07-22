package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.model.purchase.OrderItem;
import com.ghost.csbstoreapi.model.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
