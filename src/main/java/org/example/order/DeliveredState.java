package org.example.order;


public class DeliveredState implements OrderState {
    @Override
    public void nextState(Order order) {
        // Estado final, sem próximo estado
    }

    @Override
    public String getStateName() {
        return "Entregue";
    }
}

