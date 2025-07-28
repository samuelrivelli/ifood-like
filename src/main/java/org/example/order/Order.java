package org.example.order;

import org.example.observer.OrderObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private OrderState state;
    private final List<OrderObserver> observers = new ArrayList<>();
    private final String id;
    private final List<Item> items;
    private final Address deliveryAddress;

    private Order(OrderBuilder builder) {
        this.id = builder.id;
        this.items = Collections.unmodifiableList(builder.items);
        this.deliveryAddress = builder.deliveryAddress;
        this.state = new ReceivedState();
    }

    public String getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
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

    // Observer methods
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

    public static class OrderBuilder {
        private final String id;
        private final List<Item> items = new ArrayList<>();
        private Address deliveryAddress;

        public OrderBuilder(String id) {
            this.id = id;
        }

        public OrderBuilder addItem(Item item) {
            items.add(item);
            return this;
        }

        public OrderBuilder setDeliveryAddress(Address address) {
            this.deliveryAddress = address;
            return this;
        }

        public Order build() {
            if (items.isEmpty()) {
                throw new IllegalStateException("Pedido precisa ter ao menos um item");
            }
            if (deliveryAddress == null) {
                throw new IllegalStateException("Endereço de entrega obrigatório");
            }
            return new Order(this);
        }
    }
}

