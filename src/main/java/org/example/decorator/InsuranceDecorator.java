package org.example.decorator;

public class InsuranceDecorator extends OrderDecorator {

    public InsuranceDecorator(OrderComponent decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double calculateDeliveryCost() {
        return super.calculateDeliveryCost() + 10.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", com seguro";
    }
}
