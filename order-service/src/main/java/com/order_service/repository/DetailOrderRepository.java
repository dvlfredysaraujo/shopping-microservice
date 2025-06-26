package com.order_service.repository;

import com.order_service.model.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, Integer> {
}
