package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;
    
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d/product/list", testBaseUrl, serverPort);
        System.out.println("Base URL "+ baseUrl );
        
    }

    @Test
    void create_product_isCorrect(ChromeDriver driver) throws Exception {
    driver.get(baseUrl);

    WebElement createProductButton = driver.findElement(By.name("create-button"));
    createProductButton.click();

    //Create product
    WebElement nameInput = driver.findElement(By.id("nameInput"));
    nameInput.clear();
    
    WebElement quantityInput = driver.findElement(By.id("quantityInput"));
    quantityInput.clear();

    String name ="Shampoo cap Bambang";
    nameInput.sendKeys(name);

    String quantity = "1";
    quantityInput.sendKeys(quantity);

    WebElement saveButton = driver.findElement(By.tagName("button"));
    saveButton.click();

    //Testing
    String currentPage = driver.getPageSource();
    assertTrue(currentPage.contains(name));
    assertTrue(currentPage.contains(quantity));   
    }
   
}
