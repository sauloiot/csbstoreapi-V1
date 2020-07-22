package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.models.purchase.ItemBuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ItemBuyOrderRepository extends JpaRepository<ItemBuyOrder, Integer> {

}
