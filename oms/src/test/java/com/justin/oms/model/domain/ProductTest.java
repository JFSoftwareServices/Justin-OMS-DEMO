package com.justin.oms.model.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.justin.oms.testdata.ItemTestDataFactory;

public class ProductTest {

  private ItemTestDataFactory itemTestDataFactory = new ItemTestDataFactory();

  @org.junit.Test
  public void createProductOk() {
    assertNotNull(this.itemTestDataFactory.createAProduct());
  }

  @org.junit.Test(expected = NullPointerException.class)
  public void createProductThrowException() {
    this.itemTestDataFactory.createAProductWithoutName();
  }

}