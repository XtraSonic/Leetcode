package dailies.palindromePartitioningII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PalindromePartitioningIITest {
    PalindromePartitioningII palindromePartitioningII;

    @Test
    void testExample1() {
        assertEquals(1, palindromePartitioningII.minCut("aab"));
    }

    @Test
    void testExample2() {
        assertEquals(0, palindromePartitioningII.minCut("a"));
    }

    @Test
    void testExample3() {
        assertEquals(1, palindromePartitioningII.minCut("ab"));
    }

    @Test
    void testEvenPalindrome() {
        assertEquals(0, palindromePartitioningII.minCut("abccba"));
    }

    @Test
    void testOddPalindrome() {
        assertEquals(0, palindromePartitioningII.minCut("abcxcba"));
    }

    @Test
    void testTwoCuts() {
        assertEquals(2, palindromePartitioningII.minCut("abcxcbabxba"));
    }

    @Test
    void testPalindromeOutOfPalindromes() {
        assertEquals(0, palindromePartitioningII.minCut("abaxaba"));
    }

    @Test
    void testLargestPalindromeEndsUpBeingCut() {
        assertEquals(2, palindromePartitioningII.minCut("abccbabcdexedcbaba"));
    }

    @Test
    void testNoPalindromes() {
        assertEquals(5, palindromePartitioningII.minCut("abcdef"));

    }
}
