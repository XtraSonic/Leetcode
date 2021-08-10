package dailies.flipStringToMonotoneIncreasing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class FlipStringToMonotoneIncreasingTest {
    FlipStringToMonotoneIncreasing flipStringToMonotoneIncreasing;

    @Test
    void testExample1() {
        assertEquals(1, flipStringToMonotoneIncreasing.minFlipsMonoIncr("00110"));
    }

    @Test
    void testExample2() {
        assertEquals(2, flipStringToMonotoneIncreasing.minFlipsMonoIncr("010110"));
    }

    @Test
    void testExample3() {
        assertEquals(2, flipStringToMonotoneIncreasing.minFlipsMonoIncr("00011000"));
    }

    @Test
    void testNoOnes() {
        assertEquals(0, flipStringToMonotoneIncreasing.minFlipsMonoIncr("000000"));
    }

    @Test
    void testNoZeros() {
        assertEquals(0, flipStringToMonotoneIncreasing.minFlipsMonoIncr("1111111"));
    }

    @Test
    void testStartWithOnesAndOnesNeedReversing() {
        assertEquals(3, flipStringToMonotoneIncreasing.minFlipsMonoIncr("1110000"));
    }

    @Test
    void testStartWithOnesAndZerosNeedReversing() {
        assertEquals(4, flipStringToMonotoneIncreasing.minFlipsMonoIncr("111110000"));
    }

    @Test
    void testBothZeroAndOneNeedToBeChanged() {
        assertEquals(2, flipStringToMonotoneIncreasing.minFlipsMonoIncr("01000000011111111101"));
    }


    @Test
    void testLongValue() {
        assertEquals(206, flipStringToMonotoneIncreasing.minFlipsMonoIncr("0100000011111100010110011110100010001010010110011101001010110100000011111100010110100010001010010110011101001010111010000001110011101001010111111110011001110100101011101011010001000101001011100101010011110010101111000101100111101000100010100101100111010010101101000000111111000101101000100010100101100111010010101110100000011100111010010101111111100110011101001010111010110100010001010010111001010100111100101010101010110011101001010111111101"));
    }

}
