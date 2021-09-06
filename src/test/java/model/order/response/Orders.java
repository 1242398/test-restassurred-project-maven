package model.order.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Orders implements Serializable {

    List<Order> orders= new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }
}
