package com.justin.oms.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justin.oms.model.domain.Order;
import com.justin.oms.repository.OrderRepository;

import lombok.NonNull;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public Order create(@NonNull Order order) {
    return orderRepository.save(order);
  }

  public List<Order> getOrdersForPastXDays(int days) {
    return orderRepository.findByCreatedDateBetween(LocalDateTime.now().minusDays(days),
        LocalDateTime.now());
  }

}
