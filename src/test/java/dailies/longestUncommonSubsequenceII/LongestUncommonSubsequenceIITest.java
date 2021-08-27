package dailies.longestUncommonSubsequenceII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LongestUncommonSubsequenceIITest {
    LongestUncommonSubsequenceII longestUncommonSubsequenceII;

    @Test
    void testExample1() {
        assertEquals(3, longestUncommonSubsequenceII.findLUSlength("aba", "cdc", "eae"));
    }

    @Test
    void testExample2() {
        assertEquals(-1, longestUncommonSubsequenceII.findLUSlength("aaa", "aaa", "aa"));
    }

    @Test
    void test3() {
        assertEquals(-1, longestUncommonSubsequenceII.findLUSlength("qaba", "qaba", "qaba", "aba", "ab"));
    }

    @Test
    void test4() {
        assertEquals(1, longestUncommonSubsequenceII.findLUSlength("aba", "aba", "aba", "ba", "q"));
    }

    @Test
    void test5() {
        assertEquals(1, longestUncommonSubsequenceII.findLUSlength("q", "aba", "aba", "aba", "ba"));
    }

    @Test
    void test6() {
        assertEquals(-1, longestUncommonSubsequenceII.findLUSlength("q", "aba", "aba", "aba", "ba", "q"));
    }

    @Test
    void test7() {
        assertEquals(3, longestUncommonSubsequenceII.findLUSlength("qaba", "qaba", "qaba", "aba", "ab", "z", "zab"));
    }

    @Test
    void test8() {
        assertEquals(-1, longestUncommonSubsequenceII.findLUSlength("a", "b", "c", "d", "e", "f", "a", "b", "c", "d", "e", "f"));
    }
}
