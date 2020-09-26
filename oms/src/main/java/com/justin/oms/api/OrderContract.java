package com.justin.oms.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.oms.model.domain.Order;

import lombok.NonNull;

@RequestMapping("/api/v1")
public interface OrderContract {

  @PostMapping(path = "order")
  ResponseEntity<Order> create(@RequestBody @NonNull Order order);

  @GetMapping(path = "orders/{days}")
  ResponseEntity<List<Order>> getOrdersForPastXDays(@PathVariable int days);

}
