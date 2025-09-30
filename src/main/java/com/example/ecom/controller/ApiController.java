package com.example.ecom.controller;

import com.example.ecom.model.Product;
import com.example.ecom.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
  private final ProductService svc;
  public ApiController(ProductService svc) { this.svc = svc; }

  @GetMapping("/products")
  public List<Product> products() { return svc.list(); }

  @GetMapping("/products/{id}")
  public Product product(@PathVariable Long id) { return svc.get(id); }
}
