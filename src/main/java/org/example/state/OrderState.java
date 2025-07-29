package org.example.state;

import org.example.order.Order;

public interface OrderState {
    void nextState(Order order);
    String getStateName();
}

