import org.example.order.*;
import org.example.strategy.ExpressDelivery;
import org.example.strategy.FreeDelivery;
import org.example.strategy.StandardDelivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryStrategyTest {

    private Order createOrderWithItems(int numItems) {
        Order.OrderBuilder builder = new Order.OrderBuilder("test-001");
        for (int i = 0; i < numItems; i++) {
            builder.addItem(new Item("Item" + i, 1, 10.0));
        }
        builder.setDeliveryAddress(new Address("Rua A", "Cidade X", "12345"));
        return builder.build();
    }

    @Test
    public void testStandardDeliveryCost() {
        Order order = createOrderWithItems(3);
        order.setDeliveryStrategy(new StandardDelivery());

        double cost = order.calculateDeliveryCost();

        assertEquals(10.0, cost);
    }

    @Test
    public void testExpressDeliveryCost() {
        Order order = createOrderWithItems(5);
        order.setDeliveryStrategy(new ExpressDelivery());

        double cost = order.calculateDeliveryCost();

        assertEquals(20.0, cost);
    }

    @Test
    public void testFreeDeliveryCost() {
        Order order = createOrderWithItems(10);
        order.setDeliveryStrategy(new FreeDelivery());

        double cost = order.calculateDeliveryCost();

        assertEquals(0.0, cost);
    }
}
