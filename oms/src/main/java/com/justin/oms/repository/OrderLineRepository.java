package com.justin.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justin.oms.model.domain.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
