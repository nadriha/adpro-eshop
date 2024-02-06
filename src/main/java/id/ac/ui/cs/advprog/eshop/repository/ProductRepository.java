package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product save(Product product) {
        //looping to replace old product to new product
        for (int i = 0; i < productData.size(); i++) {
            if (productData.get(i).getProductId().equals(product.getProductId())) {
                productData.set(i, product);
                break;
            }
        }
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Optional<Product> findById(String id){
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty(); 
    }
}
