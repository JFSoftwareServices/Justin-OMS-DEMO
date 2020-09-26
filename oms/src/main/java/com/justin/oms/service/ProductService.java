package com.justin.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.justin.oms.model.domain.Product;
import com.justin.oms.repository.ProductRepository;

import lombok.NonNull;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product create(@NonNull Product product) {
    return productRepository.save(product);
  }

  public Product update(@NonNull Product product, long id) {
    if (!productRepository.existsById(id)) {
      throw new ResourceNotFoundException("Product does not exit");
    }
    product.setId(id);
    return productRepository.save(product);
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public void softDelete(long id) {
    if (!productRepository.existsById(id)) {
      throw new ResourceNotFoundException("Product does not exit");
    }
    productRepository.deleteById(id);
  }

}
