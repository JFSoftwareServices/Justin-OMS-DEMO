package com.justin.oms.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.oms.model.domain.Product;

import lombok.NonNull;

@RequestMapping("/api/v1")
public interface ProductContract {

  @PostMapping(path = "product")
  ResponseEntity<Product> create(@RequestBody @NonNull Product product);

  @PutMapping(path = "product/{id}")
  ResponseEntity<Product> update(@RequestBody @NonNull Product product, @PathVariable long id);

  @GetMapping(path = "products")
  ResponseEntity<List<Product>> getAll();

  @DeleteMapping(path = "product/{id}")
  ResponseEntity softDelete(@PathVariable long id);

}
