package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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


}