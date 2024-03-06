package id.ac.ui.cs.advprog.eshop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Arrays;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

@Getter
public class Payment {
    String id;
    String method;
    @Setter
    String status;
    Map<String, String> paymentData;
    Order order;

    public Payment(String id, String method, Order order, Map<String, String> paymentData){
        this.id = id;
        this.method = method;
        this.order = order;
        this.status = PaymentStatus.WAITING_PAYMENT.getValue();

        if (paymentData.isEmpty()){
            throw new IllegalArgumentException();
        } else if (order == null){
            throw new IllegalArgumentException();
        } else if (!PaymentStatus.contains(status)){
            throw new IllegalArgumentException();
        } else if (method.equals("VOUCHER_CODE")){
            if (paymentData.get("voucherCode") == null){
                this.status = PaymentStatus.REJECTED.getValue();
            } else {
                this.status = checkVoucher(paymentData.get("voucherCode"));
            }
        } else if (method.equals("BANK_TRANSFER")){
            if (paymentData.get("bankName") == null || paymentData.get("referenceCode") == null){
                this.status = PaymentStatus.REJECTED.getValue();
            } else {
                this.status = PaymentStatus.SUCCESS.getValue();
            }
        }
    }

    public String checkVoucher(String voucherCode){
        System.out.println(voucherCode);
        if ((voucherCode.length() != 16) || (!voucherCode.startsWith("ESHOP"))){
            return PaymentStatus.REJECTED.getValue();
        } else {
            int countNumeric = 0;
            for (int i = 0; i < voucherCode.length(); i++) {
                if (Character.isDigit(voucherCode.charAt(i))) {
                    countNumeric++;
                }
            }
            if (countNumeric == 8){
                return PaymentStatus.SUCCESS.getValue();
            } else {return PaymentStatus.REJECTED.getValue();}
        }
    }

    public Payment setStatus(Payment payment, String status){
        if (PaymentStatus.contains(status)) {
            payment.order.setStatus(status);
            payment.status = status;
            return payment;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
