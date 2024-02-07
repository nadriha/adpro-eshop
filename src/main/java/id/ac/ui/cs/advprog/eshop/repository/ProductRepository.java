package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product delete(String id) {
        Product product = findById(id);
        if (product == null){
            return null;
        }
        int index = findIndex(product);
        productData.remove(index);

        return product;
    }

    public Product save(Product product) {
        int index = findIndex(product);
        if (index == -1){
            return null;
        }
        productData.set(index, product);
        return product;
    }

    public int findIndex(Product product){
        for (int i = 0; i < productData.size(); i++) {
            if (productData.get(i).getProductId().equals(product.getProductId())) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product findById(String id){
        for (Product product : productData) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
