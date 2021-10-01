package y2021.m10.longestCommonSubsequence;

public class LongestCommonSubsequenceApproach2 implements LongestCommonSubsequence {
    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length())
            return calculateLongestCommonSubsequence(text1, text2);
        else
            return calculateLongestCommonSubsequence(text2, text1);
    }

    private int calculateLongestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
