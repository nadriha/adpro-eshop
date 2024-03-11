package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(String id, Order order, String method, Map<String, String> paymentData){
        if (paymentRepository.findById(id) == null){

            Payment payment = new Payment(id, method, order, paymentData);
            paymentRepository.save(payment);

            return payment;
        }
        return null;
    }

    @Override
    public Payment setStatus(Payment payment, String status){
        if (payment != null){
            payment.setStatus(status);
            
            if (status.equals("SUCCESS")){
                payment.getOrder().setStatus("SUCCESS");
            } else if (status.equals("REJECTED")){
                payment.getOrder().setStatus("FAILED");
            }

            paymentRepository.save(payment);
            return payment;
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Payment getPayment(String id){
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAllPayments(){
        return paymentRepository.getAllPayments();
    }
}
