package dailies.verifyPreorderSerializationOfABinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class VerifyPreorderSerializationOfABinaryTreeTest {
    VerifyPreorderSerializationOfABinaryTree verifyPreorderSerializationOfABinaryTree;

    @Test
    void testExample1() {
        assertTrue(verifyPreorderSerializationOfABinaryTree.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    @Test
    void testExample2() {
        assertFalse(verifyPreorderSerializationOfABinaryTree.isValidSerialization("1,#"));
    }

    @Test
    void testExample3() {
        assertFalse(verifyPreorderSerializationOfABinaryTree.isValidSerialization("9,#,#,1"));
    }
}
