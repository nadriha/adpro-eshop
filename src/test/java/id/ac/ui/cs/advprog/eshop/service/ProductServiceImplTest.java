package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    
    @Test
    public void findByIdTest() {
        String id = "123";
        Product mockProduct = new Product();

        mockProduct.setProductId(id);
        mockProduct.setProductName("Product Name");

        when(productRepository.findById(id)).thenReturn(mockProduct);

        Product found = productService.findById(id);

        assertEquals(mockProduct.getProductName(), found.getProductName());
    }

    @Test
    public void createTest() {
        Product mockProduct = new Product();
        mockProduct.setProductId("123");
        mockProduct.setProductName("Product");

        when(productRepository.create(mockProduct)).thenReturn(mockProduct);

        Product created = productService.create(mockProduct);

        assertEquals(mockProduct.getProductName(), created.getProductName());
    }

    @Test
    public void deleteTest() {
        String id = "123";
        Product mockProduct = new Product();
        mockProduct.setProductId("123");
        mockProduct.setProductName("Product");

        when(productRepository.delete(id)).thenReturn(mockProduct);

        Product deleted = productService.delete(id);

        assertEquals(mockProduct.getProductName(), deleted.getProductName());
    }

    @Test
    public void saveTest() {
        Product mockProduct = new Product();
        mockProduct.setProductId("123");
        mockProduct.setProductName("Product");

        when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        Product saved = productService.save(mockProduct);

        assertEquals(mockProduct.getProductName(), saved.getProductName());
    }

    @Test
    public void findAllTest() {
        Product mockProduct1 = new Product();
        mockProduct1.setProductId("123");
        mockProduct1.setProductName("Product1");

        Product mockProduct2 = new Product();
        mockProduct2.setProductId("456");
        mockProduct2.setProductName("Product2");

        List<Product> mockProducts = Arrays.asList(mockProduct1, mockProduct2);

        when(productRepository.findAll()).thenReturn(mockProducts.iterator());

        List<Product> foundProducts = productService.findAll();

        assertEquals(2, foundProducts.size());
        assertEquals(mockProduct1.getProductName(), foundProducts.get(0).getProductName());
        assertEquals(mockProduct2.getProductName(), foundProducts.get(1).getProductName());
    }
}