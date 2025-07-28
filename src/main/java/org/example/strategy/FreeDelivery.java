package org.example.strategy;

import org.example.order.Address;

public class FreeDelivery implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost(Address address) {
        return 0.0;
    }
}

