package org.example.order;

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

