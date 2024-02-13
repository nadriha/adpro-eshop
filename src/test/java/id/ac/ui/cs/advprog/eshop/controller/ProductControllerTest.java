package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @InjectMocks
    ProductController productController;

    @BeforeEach
    void setUp() {
    }

    @Mock
    ProductServiceImpl productService;

    @Test
    void testCreateProductPage() {
        Model model = mock(Model.class);
        String result = productController.createProductPage(model);
        assertEquals("createProduct", result);
    }

    @Test
    void testCreateProductPost() {
        Model model = mock(Model.class);
        Product product = new Product();

        when(productService.create(any(Product.class))).thenReturn(product);
        String viewName = productController.createProductPost(product, model);
        verify(productService, times(1)).create(any(Product.class));
        assert(viewName.equals("redirect:list"));
    }


    @Test
    void testProductListPage() {
        Model model = mock(Model.class);
        when(productService.findAll()).thenReturn(null);

        String result = productController.productListPage(model);
        assertEquals("productList", result);
    }

    @Test
    void testEditProductPage() {
        // Arrange
        // Product product1 = new Product();
        Model model = mock(Model.class);

        // product1.setProductId("1");
        // productService.create(product1);

        String id = "1";
        Product product2 = new Product();
        when(productService.findById(id)).thenReturn(product2);

        String viewName = productController.editProductPage(id, model);

        assert(viewName.equals("editProduct"));
    }

    @Test
    void testDeleteProduct() {
        String id = "1";

        String viewName = productController.deleteProduct(id);

        assert(viewName.equals("redirect:/product/list"));
    }

    @Test
    void testSaveProductPost() {
        Model model = mock(Model.class);
        Product product = new Product();

        String viewName = productController.saveProductPost(product, model);

        assert(viewName.equals("redirect:list"));
    }

}