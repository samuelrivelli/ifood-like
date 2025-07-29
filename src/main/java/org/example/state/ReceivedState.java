package org.example.state;

import org.example.order.Order;

public class ReceivedState implements OrderState {
    @Override
    public void nextState(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public String getStateName() {
        return "Recebido";
    }
}

