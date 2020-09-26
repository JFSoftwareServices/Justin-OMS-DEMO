package com.justin.oms.testdata;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.justin.oms.model.domain.Product;

@Component
public class ItemTestDataFactory {

  public Product createAProduct() {
    return Product.builder()
        .id(1)
        .name("JustinProd1")
        .price(new BigDecimal(10.00))
        .createdDate(LocalDateTime.now())
        .build();
  }

  public Product createAProductWithoutName() {
    return Product.builder()
        .id(-1)
        .price(new BigDecimal(10.00))
        .build();
  }

}
