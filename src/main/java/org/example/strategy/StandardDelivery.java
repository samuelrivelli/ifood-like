package org.example.strategy;

import org.example.order.Address;

public class StandardDelivery implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost(Address address) {
        return 10.0; // custo fixo
    }
}
