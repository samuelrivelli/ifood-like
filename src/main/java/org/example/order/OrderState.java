package org.example.order;

public interface OrderState {
    void nextState(Order order);
    String getStateName();
}

