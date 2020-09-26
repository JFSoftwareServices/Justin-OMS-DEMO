package com.justin.oms.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.justin.oms.model.domain.Product;
import com.justin.oms.repository.ProductRepository;
import com.justin.oms.testdata.ItemTestDataFactory;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

  private ItemTestDataFactory itemTestDataFactory = new ItemTestDataFactory();

  private Product product;

  @Mock
  private ProductRepository productRepository;

  private ProductService productService;

  @Before
  public void setUp() {
    product = itemTestDataFactory.createAProduct();
    when(productRepository.save(any())).thenReturn(product);
    when(productRepository.findAll()).thenReturn(Arrays.asList(product));
    when(productRepository.existsById(anyLong())).thenReturn(true);
    productService = new ProductService(productRepository);
  }

  @Test
  public void create() {
    assertNotNull(productService.create(product));
  }

  @Test
  public void update() {
    assertNotNull(productService.update(product,1));
  }

  @Test
  public void getAll() {
    assertNotNull(productService.getAll());
  }

  @Test
  public void softDelete() {
    productService.softDelete(1);
  }

}