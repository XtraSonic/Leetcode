package dailies.complexNumberMultiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ComplexNumberMultiplicationTest {
    ComplexNumberMultiplication complexNumberMultiplication;

    @Test
    void testExample1() {
        assertEquals("0+2i", complexNumberMultiplication.complexNumberMultiply("1+1i", "1+1i"));
    }

    @Test
    void testExample2() {
        assertEquals("0+-2i", complexNumberMultiplication.complexNumberMultiply("1+-1i", "1+-1i"));
    }

    @Test
    void testWithZero() {
        assertEquals("0+0i", complexNumberMultiplication.complexNumberMultiply("0+0i", "1+-1i"));

    }

    @Test
    void testWithZeroAsB() {
        assertEquals("0+0i", complexNumberMultiplication.complexNumberMultiply("1+-1i", "0+0i"));

    }
}
