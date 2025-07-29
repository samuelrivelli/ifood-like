package org.example.state;


import org.example.order.Order;

public class PreparingState implements OrderState {
    @Override
    public void nextState(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public String getStateName() {
        return "Preparando";
    }
}

