package com.justin.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.justin.oms.api.ProductContract;
import com.justin.oms.model.domain.Product;
import com.justin.oms.service.ProductService;

import lombok.NonNull;

@RestController
public class ProductController implements ProductContract {

  @Autowired
  private ProductService productService;

  @Override
  public ResponseEntity<Product> create(@NonNull Product product) {
    return ResponseEntity.ok(productService.create(product));
  }

  @Override
  public ResponseEntity<Product> update(@NonNull Product product, long id) {
    return ResponseEntity.ok(productService.update(product, id));
  }

  @Override
  public ResponseEntity<List<Product>> getAll() {
    return ResponseEntity.ok(productService.getAll());
  }

  @Override
  public ResponseEntity softDelete(long id) {
    productService.softDelete(id);
    return ResponseEntity.noContent().build();
  }

}
