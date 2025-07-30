package org.example.facade;

import org.example.order.*;
import org.example.state.ReceivedState;
import org.example.strategy.DeliveryStrategy;

public class OrderFacade {

    public Order createAndProcessOrder(String orderId, Address address, Item... items) {
        Order.OrderBuilder builder = new Order.OrderBuilder(orderId).setDeliveryAddress(address);
        for (Item item : items) {
            builder.addItem(item);
        }

        Order order = builder.build();

        order.setState(new ReceivedState());


        return order;
    }

    public void applyDeliveryStrategy(Order order, DeliveryStrategy strategy) {
        order.setDeliveryStrategy(strategy);
    }

    public double calculateDelivery(Order order) {
        return order.calculateDeliveryCost();
    }

    public void advanceOrderState(Order order) {
        order.nextState();
    }

    public String getOrderSummary(Order order) {
        return order.getDescription() + " - Estado: " + order.getStateName();
    }
}

