package dailies.decodeWays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class DecodeWaysTest {
    DecodeWays decodeWays;

    @Test
    void testExample1() {
        assertEquals(2, decodeWays.numDecodings("12"));
    }


    @Test
    void testExample2() {
        assertEquals(3, decodeWays.numDecodings("226"));
    }

    @Test
    void testExample3() {
        assertEquals(0, decodeWays.numDecodings("0"));
    }

    @Test
    void testExample4() {
        assertEquals(0, decodeWays.numDecodings("06"));
    }


    @Test
    void test1112() {
        assertEquals(5, decodeWays.numDecodings("1112"));
    }

    @Test
    void test11112() {
        assertEquals(8, decodeWays.numDecodings("11112"));
    }

    @Test
    void test111112() {
        assertEquals(13, decodeWays.numDecodings("111112"));
    }

    @Test
    void test1111112() {
        assertEquals(21, decodeWays.numDecodings("1111112"));
    }

    @Test
    void test27() {
        assertEquals(1, decodeWays.numDecodings("27"));
    }

    @Test
    void test1101() {
        assertEquals(1, decodeWays.numDecodings("1101"));
    }

    @Test
    void test1201234() {
        assertEquals(3, decodeWays.numDecodings("1201234"));
    }

    @Test
    void test10() {
        assertEquals(1, decodeWays.numDecodings("10"));
    }

    @Test
    void test111111111111111111111111111111111111111111111() {
        assertEquals(1836311903, decodeWays.numDecodings("111111111111111111111111111111111111111111111"));

    }
}
