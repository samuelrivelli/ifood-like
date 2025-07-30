import org.example.command.AdvanceOrderStateCommand;
import org.example.order.Address;
import org.example.order.Item;
import org.example.order.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OrderCommandTest {

    @Test
    void testAdvanceStateCommandChangesOrderState() {
        Order order = new Order.OrderBuilder("123")
                .addItem(new Item("Produto X", 1, 4.0))
                .setDeliveryAddress(new Address("Rua A", "Cidade B", "12345-678"))
                .build();

        String initialState = order.getStateName();

        AdvanceOrderStateCommand command = new AdvanceOrderStateCommand(order);
        command.execute();

        String nextState = order.getStateName();

        assertNotEquals(initialState, nextState);
    }
}
