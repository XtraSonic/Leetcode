package dailies.verifyPreorderSerializationOfABinaryTree;

public class VerifyPreorderSerializationOfABinaryTreeApproach1 implements VerifyPreorderSerializationOfABinaryTree {

    @Override
    public boolean isValidSerialization(String preorder) {
        int expectedNumberOfHashtags = 1;
        for (int i = 0; i < preorder.length(); i++) {
            char character = preorder.charAt(i);
            if (character == '#') {
                expectedNumberOfHashtags--;
                i++;// "read" the next comma
            } else {
                if (expectedNumberOfHashtags > 0) {
                    expectedNumberOfHashtags++;
                    do {
                        i++;// "read" the whole number
                    } while (preorder.charAt(i) != ',');
                } else {
                    return false;
                }
            }
        }
        return expectedNumberOfHashtags == 0;
    }
}
