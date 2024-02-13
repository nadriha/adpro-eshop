package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Product;

public interface ProductService {
    Product create(Product product);
    Product findById(String id);
    Product save(Product product);
    Product delete(String id);
    List<Product> findAll();
}
