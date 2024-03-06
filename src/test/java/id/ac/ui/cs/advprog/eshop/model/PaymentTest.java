package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class PaymentTest {
    List<Product> products;
    Order order;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        Product product1 = new Product();

        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);

        order = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products, 1708560000L,"Safira Sudrajat");

    }

    @Test
    void testCreatePaymentWithNoPaymentData(){
        this.paymentData.clear();
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "", order, paymentData);
        });
    }

    @Test
    void testCreatePaymentWithValidVoucher(){
        paymentData.put("voucherCode","ESHOPNGG12345678");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "VOUCHER_CODE", order, paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidNumericalCharacter(){
        paymentData.put("voucherCode","ESHOPNGG12GHYJL34");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "VOUCHER_CODE", order, paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidEshopCode(){
        paymentData.put("voucherCode","BALGEBUN9543539");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "VOUCHER_CODE", order, paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentWithValidBankTrasfer(){
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "1234");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "BANK_TRANSFER", order, paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidBankName(){
        paymentData.put("referenceCode", "1234");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "BANK_TRANSFER", order, paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidReferenceCode(){
        paymentData.put("bankName", "BNI");
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-71afhy6dfbd6", "BANK_TRANSFER", order, paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
    


    
}
