package com.justin.oms.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justin.oms.model.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

  public List<Order> findByCreatedDateBetween(LocalDateTime from, LocalDateTime to);

}
