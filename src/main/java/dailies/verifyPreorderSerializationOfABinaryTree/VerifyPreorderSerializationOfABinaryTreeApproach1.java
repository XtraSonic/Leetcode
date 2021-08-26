package dailies.verifyPreorderSerializationOfABinaryTree;

public class VerifyPreorderSerializationOfABinaryTreeApproach1 implements VerifyPreorderSerializationOfABinaryTree {

    @Override
    public boolean isValidSerialization(String preorder) {
        int expectedNumberOfHashtags = 1;
        String[] chars = preorder.split(",");
        for (int i = 0; i < chars.length; i++) {
            String character = chars[i];
            if (character.equals("#")) {
                expectedNumberOfHashtags--;
            } else {
                if (expectedNumberOfHashtags > 0) {
                    expectedNumberOfHashtags++;
                } else {
                    return false;
                }
            }
        }
        return expectedNumberOfHashtags == 0;
    }
}
