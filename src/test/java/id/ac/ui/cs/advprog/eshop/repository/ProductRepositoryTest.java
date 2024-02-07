package id.ac.ui.cs.advprog.eshop.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Product;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId(product1.getProductId());
        product2.setProductName("Sampo Cap Bango");
        product2.setProductQuantity(500);

        productRepository.save(product2); //save tuh save edit maksudnya

        Iterator<Product> productIterator = productRepository.findAll();

        Product editedProduct = productIterator.next();
        assertEquals(editedProduct.getProductId(), product1.getProductId());
        assertNotEquals(editedProduct.getProductName(), product1.getProductName());

        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProductIfEmpty(){
        Product product = new Product();
        product.setProductId("");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        Product editedProduct = productRepository.save(product);
        assertNull(editedProduct);
    }

    @Test
    void testDeleteProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("ebaghalo-1c39-460e-8860-7haihaibd6");
        product2.setProductName("Sampo Cap Bango");
        product2.setProductQuantity(500);

        productRepository.create(product2);

        productRepository.delete(product2.getProductId()); //save tuh save edit maksudnya

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        productRepository.delete(product1.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteProductIfEmpty(){
        Product product = new Product();
        product.setProductId("ebaghalo-1c39-460e-8860-7haihaibd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        Product editedProduct = productRepository.delete(product.getProductId());
        assertNull(editedProduct);
    }
}
