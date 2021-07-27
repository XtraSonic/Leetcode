package dailies.threeSumClosest;

public class ThreeSumClosestApproach1 implements ThreeSumClosest {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int current = Math.abs(target - sum);
                    if (current < min) {
                        min = current;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
