package com.example.ecom.controller;

import com.example.ecom.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
  private final ProductService svc;
  public HomeController(ProductService svc) { this.svc = svc; }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("products", svc.list());
    return "index";
  }

  @GetMapping("/product/{id}")
  public String product(@PathVariable Long id, Model model) {
    model.addAttribute("product", svc.get(id));
    return "product";
  }

  @GetMapping("/cart")
  public String cart() { return "cart"; }

  @PostMapping("/cart/add")
  public String addToCart() { return "redirect:/cart"; }

  @GetMapping("/checkout")
  public String checkout() { return "checkout"; }
}
