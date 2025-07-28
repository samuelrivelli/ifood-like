package org.example.order;

import org.example.observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private OrderState state;
    private final List<OrderObserver> observers = new ArrayList<>();
    private final String id;

    public Order(String id) {
        this.id = id;
        this.state = new ReceivedState();
    }

    public String getId() {
        return id;
    }

    public String getStateName() {
        return state.getStateName();
    }

    public void setState(OrderState state) {
        this.state = state;
        notifyObservers();
    }

    public void nextState() {
        state.nextState(this);
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
}

