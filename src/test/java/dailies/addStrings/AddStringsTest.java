package dailies.addStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AddStringsTest {
    AddStrings addStrings;

    @Test
    void testExample1() {
        assertEquals("134", addStrings.addStrings("11", "123"));
    }


    @Test
    void testExample2() {
        assertEquals("533", addStrings.addStrings("456", "77"));
    }

    @Test
    void testExample3() {
        assertEquals("0", addStrings.addStrings("0", "0"));
    }

    @Test
    void testResultLongerThanBothInputs() {
        assertEquals("10001", addStrings.addStrings("9999", "2"));
    }
}
