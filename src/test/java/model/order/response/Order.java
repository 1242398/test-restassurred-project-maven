package model.order.response;

import java.io.Serializable;

public class Order implements Serializable {
     private String orderId;
    private String orderNo;
    private String itemName ;
    private String  quantity;
    private String amount;
    private DeliverAdress deliverAdress;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public DeliverAdress getDeliverAdress() {
        return deliverAdress;
    }

    public void setDeliverAdress(DeliverAdress deliverAdress) {
        this.deliverAdress = deliverAdress;
    }
}
