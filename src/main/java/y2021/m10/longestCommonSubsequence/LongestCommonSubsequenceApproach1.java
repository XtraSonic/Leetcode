package y2021.m10.longestCommonSubsequence;

public class LongestCommonSubsequenceApproach1 implements LongestCommonSubsequence {

    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length())
            return calculateLongestCommonSubsequence(text1, text2);
        else
            return calculateLongestCommonSubsequence(text2, text1);
    }

    private int calculateLongestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        char currentChar = text1.charAt(0);
        String restOfText1 = text1.substring(1);
        int resultWithoutTakingLetter = calculateLongestCommonSubsequence(restOfText1, text2);
        int i = 0;
        while (i < text2.length() && currentChar != text2.charAt(i)) i++;
        if (i < text2.length()) {
            return Math.max(resultWithoutTakingLetter, 1 + calculateLongestCommonSubsequence(restOfText1, text2.substring(i + 1)));
        } else {
            return resultWithoutTakingLetter;
        }
    }
}
