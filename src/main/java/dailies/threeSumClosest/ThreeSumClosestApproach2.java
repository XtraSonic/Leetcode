package dailies.threeSumClosest;

import java.util.Arrays;

public class ThreeSumClosestApproach2 implements ThreeSumClosest {

    @Override
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentInt = nums[i];
            int newTarget = target - currentInt;
            int indexLow = i + 1;
            int indexHigh = nums.length - 1;
            while (indexLow < indexHigh) {
                int sum = nums[indexLow] + nums[indexHigh];
                int currentDiff = Math.abs(newTarget - sum);
                if (currentDiff < min) {
                    min = currentDiff;
                    result = sum + currentInt;
                }
                if (sum == newTarget) return target;
                if (sum > newTarget) indexHigh--;
                if (sum < newTarget) indexLow++;
            }
        }
        return result;
    }
}
