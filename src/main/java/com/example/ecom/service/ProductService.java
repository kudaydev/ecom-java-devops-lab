package com.example.ecom.service;

import com.example.ecom.model.Product;
import com.example.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository repo;
  public ProductService(ProductRepository repo) { this.repo = repo; }

  public List<Product> list() { return repo.findAll(); }
  public Product get(Long id) { return repo.findById(id).orElse(null); }
}
