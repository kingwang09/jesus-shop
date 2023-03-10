package org.jesus.shop.domain.order.repository;

import org.jesus.shop.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}