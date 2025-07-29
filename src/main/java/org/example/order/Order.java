package org.example.order;

import org.example.decorator.OrderComponent;
import org.example.observer.OrderObserver;
import org.example.protoype.Prototype;
import org.example.state.OrderState;
import org.example.state.ReceivedState;
import org.example.strategy.DeliveryStrategy;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderComponent, Prototype<Order>, Cloneable {
    private OrderState state;
    private List<OrderObserver> observers = new ArrayList<>();
    private String id;
    private List<Item> items;
    private Address deliveryAddress;
    private DeliveryStrategy deliveryStrategy;

    private Order(OrderBuilder builder) {
        this.id = builder.id;
        this.items = builder.items;
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

    public void setDeliveryStrategy(DeliveryStrategy strategy) {
        this.deliveryStrategy = strategy;
    }

    @Override
    public double calculateDeliveryCost() {
        if (deliveryStrategy == null) {
            throw new IllegalStateException("Tipo de entrega nao atribuido.");
        }
        return deliveryStrategy.calculateDeliveryCost(deliveryAddress);
    }

    public String getDescription() {
        int totalQuantity = items.stream()
                .mapToInt(Item::getQuantity)
                .sum();
        return "Pedido " + id + " com " + totalQuantity + " itens";
    }

    @Override
    public Order clone() {
        try {
            Order cloned = (Order) super.clone();
            cloned.items = new ArrayList<>(this.items);
            cloned.deliveryAddress = this.deliveryAddress != null ? this.deliveryAddress.clone() : null;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
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

