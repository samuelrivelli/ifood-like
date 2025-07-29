package org.example.decorator;

public class GiftWrapDecorator extends OrderDecorator {

    public GiftWrapDecorator(OrderComponent decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double calculateDeliveryCost() {
        return super.calculateDeliveryCost() + 5.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", com embalagem para presente";
    }
}
