import static org.junit.jupiter.api.Assertions.*;

import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.example.singleton.OrderManager;
import org.junit.jupiter.api.Test;

public class OrderManagerTest {

    @Test
    public void testSingletonInstance() {
        OrderManager instance1 = OrderManager.getInstance();
        OrderManager instance2 = OrderManager.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void testAddAndGetOrder() {
        OrderManager manager = OrderManager.getInstance();
        Order order = new Order.OrderBuilder("test-003")
                .addItem(new Item("Item3", 1, 5.0))
                .setDeliveryAddress(new Address("Street 3", "City", "54321"))
                .build();

        manager.addOrder(order);

        Order retrieved = manager.getOrder("test-003");

        assertNotNull(retrieved);
        assertEquals("test-003", retrieved.getId());
    }
}
