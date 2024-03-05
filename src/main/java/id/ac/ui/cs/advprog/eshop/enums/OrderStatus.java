package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    FAILED("FAILED"),
    SUCCESS("SUCCESS"),
    CANCELLED("CANCELLED");

    private final String value;

    private OrderStatus(String value) {
        this.value = value; //set value order status
    }

    //cek kalau string yang dikasih tuh cocok ga sama nama konstanta enum
    public static boolean contains(String param){
        for (OrderStatus orderStatus : OrderStatus.values()){
            if (orderStatus.name().equals(param)){
                return true; //berarti valid
            }
        }

        return false;
    }
}
