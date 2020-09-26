package com.justin.oms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.justin.oms.model.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Override
  @Query("select e from #{#entityName} e where e.deleted=false")
  public List<Product> findAll();

}
