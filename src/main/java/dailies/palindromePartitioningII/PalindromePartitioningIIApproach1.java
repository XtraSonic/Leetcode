package dailies.palindromePartitioningII;

public class PalindromePartitioningIIApproach1 implements PalindromePartitioningII {

    @Override
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        boolean[][] palindroms = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                palindroms[i][j] = false;
            }
        }

        int[] minCutsForLength = new int[chars.length + 1];
        for (int i = 0; i <= chars.length; i++) {
            //we can't have a min cut larger or equal to the length of the string so the starting value is length of the string - 1
            minCutsForLength[i] = i - 1;
        }

        for (int i = 1; i < chars.length; i++) {// i represents the end index in the array
            for (int j = 0; j <= i; j++) { // j represents the start index in the array
                if (chars[i] == chars[j])
                    if (i == j || i == j + 1 || palindroms[i - 1][j + 1]) // 1 character, consecutive chars or chars which have a palindrome between them
                    {
                        // since the 2 chars are equal and the string between them is also a palindrome,
                        // the extended string is also a palindrome
                        palindroms[i][j] = true;

                        // we found a palindrome from j to i
                        // we know the min cut for the string from 0 to j
                        // the min cut for the string from 0 to i is the minimum between the current min cut for 0 to i
                        // and 1(this new cut) + min cut for 0 to j (but excluding j)
                        minCutsForLength[i + 1] = Math.min(minCutsForLength[i + 1], minCutsForLength[j] + 1);
                    }
            }
        }
        return minCutsForLength[chars.length];
    }
}
