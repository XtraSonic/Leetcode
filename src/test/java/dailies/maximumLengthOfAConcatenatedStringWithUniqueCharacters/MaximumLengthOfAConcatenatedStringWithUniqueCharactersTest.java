package dailies.maximumLengthOfAConcatenatedStringWithUniqueCharacters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MaximumLengthOfAConcatenatedStringWithUniqueCharactersTest {
    MaximumLengthOfAConcatenatedStringWithUniqueCharacters maximumLengthOfAConcatenatedStringWithUniqueCharacters;

    @Test
    void testExample1() {
        assertEquals(4, maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(Arrays.asList("un", "iq", "ue")));
    }

    @Test
    void testExample2() {
        assertEquals(6, maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(Arrays.asList("cha", "r", "act", "ers")));
    }

    @Test
    void testExample3() {
        assertEquals(26, maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }

    @Test
    void testMultipleJoin() {
        assertEquals(4, maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(Arrays.asList("u", "nn", "i", "q", "ue")));

    }

    @Test
    void testLargeOverlap() {
        assertEquals(26, maximumLengthOfAConcatenatedStringWithUniqueCharacters.maxLength(Arrays.asList("abcdefghijklm", "mnopqrstuvwxy", "nopqrstuvwxyz")));
    }
}
