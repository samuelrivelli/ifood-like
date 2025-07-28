package org.example.order;


public class ShippedState implements OrderState {
    @Override
    public void nextState(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public String getStateName() {
        return "Enviado";
    }
}

