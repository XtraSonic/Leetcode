package y2021.m10.longestCommonSubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LongestCommonSubsequenceTest {
    LongestCommonSubsequence longestCommonSubsequence;

    @Test
    void testExample1() {
        assertEquals(3, longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    void testExample2() {
        assertEquals(3, longestCommonSubsequence.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    void testExample3() {
        assertEquals(0, longestCommonSubsequence.longestCommonSubsequence("abc", "dfe"));
    }


    @Test
    void testOutSubsequence() {
        assertEquals(3, longestCommonSubsequence.longestCommonSubsequence("axbcydez", "fzgxhiytjkz"));
    }

    @Test
    void testLongTest() {
        assertEquals(103, longestCommonSubsequence.longestCommonSubsequence("axbcasdubiasdufaudshfawsfgdycakvyfgvchuygqaiwfcakhjyfgcasdbfgyfgsudasdfjbasdiufhajdsfgiauswfbdjkadsydez", "axbcasdubiasdufaudshfawsfgdycakvyfgvchuygqaiwfcakhjyfgcasdbfgyfgsudasdfjbasdiufhajdsfgiauswfbdjkadsydez"));
    }
}
