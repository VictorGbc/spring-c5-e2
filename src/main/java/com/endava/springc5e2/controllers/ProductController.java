package com.endava.springc5e2.controllers;

import com.endava.springc5e2.model.Product;
import com.endava.springc5e2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/get")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
