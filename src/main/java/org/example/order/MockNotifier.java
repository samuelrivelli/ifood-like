package org.example.order;

import org.example.observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class MockNotifier implements OrderObserver {

    private final List<String> notifications = new ArrayList<>();

    @Override
    public void update(Order order) {
        String message = "Pedido " + order.getId() + " mudou para o estado: " + order.getStateName();
        notifications.add(message);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
