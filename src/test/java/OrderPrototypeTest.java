import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderPrototypeTest {

    @Test
    public void testCloneCreatesSeparateInstance() {
        Order original = new Order.OrderBuilder("1001")
                .addItem(new Item("Produto X", 2, 50.0))
                .addItem(new Item("Produto Y", 1, 30.0))
                .setDeliveryAddress(new Address("Rua A", "Cidade B", "12345"))
                .build();

        Order clone = original.clone();

        assertNotSame(original, clone);

        assertEquals(original.getId(), clone.getId());
        assertEquals(original.getDeliveryAddress().getStreet(), clone.getDeliveryAddress().getStreet());

        assertEquals(original.getItems().size(), clone.getItems().size());
        assertNotSame(original.getItems(), clone.getItems());

        clone.getItems().add(new Item("Produto Z", 1, 20.0));
        assertEquals(2, original.getItems().size());
        assertEquals(3, clone.getItems().size());
    }

    @Test
    public void testCloneIndependentAddress() {
        Order original = new Order.OrderBuilder("1002")
                .addItem(new Item("Produto A", 1, 10.0))
                .setDeliveryAddress(new Address("Rua C", "Cidade D", "54321"))
                .build();

        Order clone = original.clone();

        clone.getDeliveryAddress().setStreet("Nova Rua");

        assertNotEquals(original.getDeliveryAddress().getStreet(), clone.getDeliveryAddress().getStreet());
    }
}
