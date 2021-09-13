package dailies.maximumNumberOfBalloons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MaximumNumberOfBalloonsTest {
    MaximumNumberOfBalloons maximumNumberOfBalloons;

    @Test
    void testExample1() {
        assertEquals(1, maximumNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));
    }

    @Test
    void testExample2() {
        assertEquals(2, maximumNumberOfBalloons.maxNumberOfBalloons("loonbalxballpoon"));
    }

    @Test
    void testExample3() {
        assertEquals(0, maximumNumberOfBalloons.maxNumberOfBalloons("leetcode"));
    }
}
