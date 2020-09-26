package com.justin.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.justin.oms.api.OrderContract;
import com.justin.oms.model.domain.Order;
import com.justin.oms.service.OrderService;

import lombok.NonNull;

@RestController
public class OrderController implements OrderContract {

  @Autowired
  private OrderService orderService;

  @Override
  public ResponseEntity<Order> create(@NonNull Order order) {
    return ResponseEntity.ok(orderService.create(order));
  }

  @Override
  public ResponseEntity<List<Order>> getOrdersForPastXDays(int days) {
    return ResponseEntity.ok(orderService.getOrdersForPastXDays(days));
  }

}
