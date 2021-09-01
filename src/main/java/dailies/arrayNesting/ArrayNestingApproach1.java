package dailies.arrayNesting;

public class ArrayNestingApproach1 implements ArrayNesting {

    @Override
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int currentMaxLength = 1;
                int nextIndex = nums[i];
                while (nextIndex != i) {
                    currentMaxLength++;
                    visited[nextIndex] = true;
                    nextIndex = nums[nextIndex];
                }
                if (maxLength < currentMaxLength) {
                    maxLength = currentMaxLength;
                }
            }
        }
        return maxLength;
    }
}
