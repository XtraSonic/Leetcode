package dailies.basicCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BasicCalculatorTest {
    BasicCalculator basicCalculator;

    @Test
    void testExample1() {
        assertEquals(2, basicCalculator.calculate("1 + 1"));
    }

    @Test
    void testExample2() {
        assertEquals(3, basicCalculator.calculate("2-1 + 2"));
    }

    @Test
    void testExample3() {
        assertEquals(23, basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    void testNegativeParenthesis() {
        assertEquals(0, basicCalculator.calculate("1-(2-1)"));
    }

    @Test
    void testNegativeNumberStart() {
        assertEquals(2, basicCalculator.calculate("-(-2-1)-1"));
    }

    @Test
    void testMultipleDigitNumbers() {
        assertEquals(-2, basicCalculator.calculate("-(22+ 1 +99) + 120"));
    }

    @Test
    void testMultipleNestedParenthesis() {
        assertEquals((1 - (4 + 5 - (4 + 1 - 2 - (99 - 29 + (33 - 2) - 22 + (32 - 1) - (24 + 7 - 12))) + 2) - 3) - (6 - 8 + 12),
                basicCalculator.calculate("(1-(4+5-(4+1-2-(99 -29 +(33-2) -22 +(32-1) -(24 +7 -12))) +2)-3)-  (6-8 +12)"));
    }
}
