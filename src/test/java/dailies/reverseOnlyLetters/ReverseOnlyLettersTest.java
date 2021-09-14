package dailies.reverseOnlyLetters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ReverseOnlyLettersTest {
    ReverseOnlyLetters reverseOnlyLetters;

    @Test
    void testExample1() {
        assertEquals("dc-ba", reverseOnlyLetters.reverseOnlyLetters("ab-cd"));
    }

    @Test
    void testExample2() {
        assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }

    @Test
    void testExample3() {
        assertEquals("Qedo1ct-eeLg=ntse-T!", reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
