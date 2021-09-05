package dailies.orderlyQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class OrderlyQueueTest {
    OrderlyQueue orderlyQueue;

    @Test
    void testExample1() {
        assertEquals("acb", orderlyQueue.orderlyQueue("cba", 1));
    }

    @Test
    void testExample2() {
        assertEquals("aaabc", orderlyQueue.orderlyQueue("baaca", 3));
    }

    @Test
    void testMultiplePossibleStartingPoints() {
        assertEquals("aaoicvasaqgrdg", orderlyQueue.orderlyQueue("vasaqgrdgaaoic", 1));
    }
}
