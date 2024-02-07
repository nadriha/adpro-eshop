package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Product;

public interface ProductService {
    public Product create(Product product);
    public Product findById(String id);
    public Product save(Product product);
    public Product delete(String id);
    public List<Product> findAll();
}
