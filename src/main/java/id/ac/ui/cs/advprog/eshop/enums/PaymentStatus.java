package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    REJECTED("REJECTED"),
    SUCCESS("SUCCESS");

    private final String value;

    private PaymentStatus(String value) {
        this.value = value; //set value order status
    }

    //cek kalau string yang dikasih tuh cocok ga sama nama konstanta enum
    public static boolean contains(String param){
        for (PaymentStatus paymentStatus : PaymentStatus.values()){
            if (paymentStatus.name().equals(param)){
                return true; 
            }
        }

        return false;
    }
}
