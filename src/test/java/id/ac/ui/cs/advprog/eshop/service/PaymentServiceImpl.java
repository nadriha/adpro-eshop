package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImpl {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    List<Payment> payments;

    @BeforeEach
    void setup(){
        payments = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6") ;
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b" ,
        products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        
        Order order2 = new Order( "7f9e15bb-4b15-42f4-aebc-c3af385fb078",
        products, 1708570000L , "Safira Sudrajat");
        orders.add(order2) ;

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP12345678QWE");

        Payment payment1 = new Payment("13652556-012a-4c07-b546-54eb1396d79a","VOUCHER_CODE", order1, paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("bankName", "BNI");
        paymentData2.put("referenceCode", "1234");

        Payment payment2 = new Payment("13652556-012a-4c07-b546-54eb1396d79z", "BANK_TRANSFER", order2, paymentData2);
        payments.add(payment2);
    }

    @Test
    void testAddPayment(){
        Payment payment = payments.get(0);

        doReturn(payment).when(paymentRepository).save(payment);

        Payment result = paymentService.addPayment(payment.getId(),payment.getOrder(), "VOUCHER_CODE", payment.getPaymentData());

        veify(paymentRepository, times(1).save(payment));
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testAddPaymentIfAlreadyExist(){
        Payment payment = payments.get(0);

        doReturn(payment).when(paymentRepository).findById(payment.getId());

        assertNull(paymentService.addPayment(payment.getId(),payment.getOrder(), "VOUCHER_CODE", payment.getPaymentData()));

        verify(paymentRepository, times(0).save(payment));
    }

    @Test
    void testSetStatus(){
        Payment payment = payments.get(0);
        Payment newPayment = paymentRepository.setStatus(payment, "SUCCESS");
        
        doReturn(payment).when(paymentRepository).findById(payment.getId());
        doReturn(newPayment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.setStatus(payment, "SUCCESS");

        assertEquals(payment.getId(), result.getId());
        assertEquals("SUCCESS", result.getStatus());
        assertEquals("SUCCESS", result.getOrder().getStatus());
        verify(paymentRepository, times(2)).save(any(Order.class));

    }

    @Test
    void testGetPaymentByIdIfIdFound() {
        Payment payment = payments.get(0);
        doReturn(payment).when(paymentRepository).findById(payment.getId());

        Order result = paymentService.findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testGetAllPayments(){
        Payment payment = payments.get(1);
        doReturn(payments).when(paymentRepository).getAllPayments();
        List<Payment> results = paymentService.getAllPayments();
        
        assertEquals(2, results.size());
    }
}
