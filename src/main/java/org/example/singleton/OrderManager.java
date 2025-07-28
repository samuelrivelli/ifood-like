package org.example.singleton;



import org.example.order.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private static OrderManager instance;
    private final Map<String, Order> orders = new HashMap<>();

    private OrderManager() {}

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }
}

