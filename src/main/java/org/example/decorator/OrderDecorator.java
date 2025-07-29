package org.example.decorator;

public abstract class OrderDecorator implements OrderComponent {
    protected final OrderComponent decoratedOrder;

    public OrderDecorator(OrderComponent decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double calculateDeliveryCost() {
        return decoratedOrder.calculateDeliveryCost();
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription();
    }
}
