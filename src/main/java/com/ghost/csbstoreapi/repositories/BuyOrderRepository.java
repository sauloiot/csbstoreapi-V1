package com.ghost.csbstoreapi.repositories;

import com.ghost.csbstoreapi.models.purchase.BuyOrder;
import com.ghost.csbstoreapi.models.user.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BuyOrderRepository extends JpaRepository<BuyOrder, Integer> {
    @Transactional(readOnly = true)
    Page<BuyOrder> findByClient(Client client, Pageable pageRequest);

}
