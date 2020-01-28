package com.endava.springc5e2.repositories;

import com.endava.springc5e2.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(Product product) {
        String sql = "INSERT INTO products VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    public List<Product> getProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Product p = new Product();
            p.setId(resultSet.getInt("id"));
            p.setName(resultSet.getString("name"));
            p.setPrice(resultSet.getDouble("price"));
            return p;
        });
    }
}
