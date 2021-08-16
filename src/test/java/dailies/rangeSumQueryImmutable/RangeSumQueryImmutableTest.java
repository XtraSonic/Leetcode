package dailies.rangeSumQueryImmutable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class RangeSumQueryImmutableTest {
    RangeSumQueryImmutable rangeSumQueryImmutable;

    @Nested
    @DisplayName("Given arrayIs_203_52_1")
    class ArrayIs203521 {
        @BeforeEach
        void setup() {
            rangeSumQueryImmutable.setArray(new int[]{-2, 0, 3, -5, 2, -1});
        }


        @Test
        void testExample1() {
            assertEquals(1, rangeSumQueryImmutable.sumRange(0, 2));
        }

        @Test
        void testExample1b() {
            assertEquals(-1, rangeSumQueryImmutable.sumRange(2, 5));
        }

        @Test
        void testExample1c() {
            assertEquals(-3, rangeSumQueryImmutable.sumRange(0, 5));
        }
    }
}
