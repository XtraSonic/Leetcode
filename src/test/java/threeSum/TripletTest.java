package threeSum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripletTest {

    @Test
    void testTriplets() {
        Triplet a1 = new Triplet(1, 2, 3);
        Triplet a2 = new Triplet(1, 3, 2);
        Triplet a3 = new Triplet(2, 1, 3);
        Triplet a4 = new Triplet(2, 3, 1);
        Triplet a5 = new Triplet(3, 1, 2);
        Triplet a6 = new Triplet(3, 2, 1);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, a1.toList());
        assertEquals(expected, a2.toList());
        assertEquals(expected, a3.toList());
        assertEquals(expected, a4.toList());
        assertEquals(expected, a5.toList());
        assertEquals(expected, a6.toList());

    }
}
