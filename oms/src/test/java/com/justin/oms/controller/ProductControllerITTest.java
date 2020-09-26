package com.justin.oms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.justin.oms.OmsApplication;
import com.justin.oms.model.domain.Product;
import com.justin.oms.testdata.ItemTestDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OmsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerITTest {

  @LocalServerPort
  private int port;

  private TestRestTemplate restTemplate = new TestRestTemplate();

  private HttpHeaders headers = new HttpHeaders();

  private ItemTestDataFactory itemTestDataFactory = new ItemTestDataFactory();

  private Product product;

  @Before
  public void setUp() {
    product = itemTestDataFactory.createAProduct();
  }

  @Test
  public void create() {
    HttpEntity<Product> entity = new HttpEntity<>(product, headers);
    ResponseEntity<Product> response = restTemplate.exchange(
        createURLWithPort("/api/v1/product"),
        HttpMethod.POST, entity, Product.class);
    System.out.println("response.getBody().getName() :" + response.getBody().getName());
    assertEquals(product.getName(), response.getBody().getName());
  }

  @Test
  public void update() {
    String updatedName = "Justin-update-test";
    product.setName(updatedName);
    product.setDeleted(false);
    HttpEntity<Product> entity = new HttpEntity<>(product, headers);
    ResponseEntity<Product> response = restTemplate.exchange(
        createURLWithPort("/api/v1/product/1"),
        HttpMethod.PUT, entity, Product.class);
    System.out.println("response.getBody().getName() :" + response.getBody().getName());
    assertEquals(updatedName, response.getBody().getName());
  }

  @Test
  public void getAll() {
    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/api/v1/products"), HttpMethod.GET, null, String.class);
    assertNotNull(response);
  }

  @Test
  public void softDelete() {
    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/api/v1/product/" + product.getId()),
        HttpMethod.DELETE, null, String.class);
    assertNotNull(response);
  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }

}