package threeSum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TupleTest {

    @Test
    void testTuple() {
        Tuple a1 = new Tuple(1, 2);
        Tuple a2 = new Tuple(2, 1);

        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, a1.toList());
        assertEquals(expected, a2.toList());
    }
}
