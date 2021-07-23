package longestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters lswrc;

    @Test
    void test_abcabcbb() {
        evaluateString(3, "abcabcbb");
    }

    @Test
    void test_bbbbb() {
        evaluateString(1, "bbbbb");
    }

    @Test
    void test_pwwkew() {
        evaluateString(3, "pwwkew");
    }

    @Test
    void test_pwewkew() {
        evaluateString(3, "pwewkew");
    }

    @Test
    void test_a() {
        evaluateString(1, "a");
    }

    @Test
    void test_aab() {
        evaluateString(2, "aab");
    }

    @Test
    void test_aaba() {
        evaluateString(2, "aaba");
    }

    @Test
    void test_aabab() {
        evaluateString(2, "aabab");
    }

    @Test
    void test_aababc() {
        evaluateString(3, "aababc");
    }

    @Test
    void test_aababca() {
        evaluateString(3, "aababca");
    }

    @Test
    void test_empty() {
        evaluateString(0, "");
    }

    private void evaluateString(int i, String bbbbb) {
        assertEquals(i, lswrc.lengthOfLongestSubstring(bbbbb));
    }

}
