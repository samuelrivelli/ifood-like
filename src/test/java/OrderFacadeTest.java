import org.example.facade.OrderFacade;
import org.example.order.*;
import org.example.state.ReceivedState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderFacadeTest {

    private OrderFacade facade;
    private Address address;
    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp() {
        facade = new OrderFacade();
        address = new Address("Rua A", "100", "SP");
        item1 = new Item("Item 1", 2, 40.0);
        item2 = new Item("Item 2", 1, 40.0);
    }

    @Test
    void testCreateAndProcessOrder() {
        Order order = facade.createAndProcessOrder("ORD-001", address, item1, item2);

        assertNotNull(order);
        assertEquals("ORD-001", order.getId());
        assertEquals(2, order.getItems().size());
    }

    @Test
    void testAdvanceOrderState() {
        Order order = facade.createAndProcessOrder("ORD-003", address, item1);
        String initialState = order.getStateName();

        facade.advanceOrderState(order);
        String nextState = order.getStateName();

        assertNotEquals(initialState, nextState);
    }

    @Test
    void testGetOrderSummary() {
        Order order = facade.createAndProcessOrder("ORD-004", address, item1);
        String summary = facade.getOrderSummary(order);

        assertTrue(summary.contains("ORD-004"));
        assertTrue(summary.contains("Recebido"));
    }
}
