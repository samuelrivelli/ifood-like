import org.example.order.Address;
import org.example.order.Item;
import org.example.order.MockNotifier;
import org.example.order.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MockNotifierTest {

    @Test
    public void testMockNotifierReceivesNotifications() {
        Order order = new Order.OrderBuilder("order-006")
                .addItem(new Item("Livro", 1, 50.0))
                .setDeliveryAddress(new Address("Rua B", "Cidade", "12345-000"))
                .build();

        MockNotifier notifier = new MockNotifier();
        order.addObserver(notifier);

        order.nextState(); // Preparando
        order.nextState(); // Enviado

        assertEquals(2, notifier.getNotifications().size());
        assertTrue(notifier.getNotifications().get(0).contains("Preparando"));
        assertTrue(notifier.getNotifications().get(1).contains("Enviado"));
    }
}
