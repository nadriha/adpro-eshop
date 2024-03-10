package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    private List<Payment> allPayments = new ArrayList<>();

    public Payment save(Payment payment) {
        int i = 0;
        for (Payment savedPayment : allPayments){
            if (savedPayment.getId().equals(payment.getId())){
                allPayments.remove(i);
                allPayments.add(i, payment);
                return payment;
            }
            i += 1;
        }
        allPayments.add(payment);
        return payment;
    }

    public Payment findById(String id) {
        for (Payment savedPayment : allPayments){
            if (savedPayment.getId().equals(id)){
                return savedPayment;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        return allPayments;
    }
    
}
