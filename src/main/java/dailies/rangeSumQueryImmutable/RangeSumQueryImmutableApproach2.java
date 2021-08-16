package dailies.rangeSumQueryImmutable;

public class RangeSumQueryImmutableApproach2 implements RangeSumQueryImmutable {

    int[] sumsSoFar;

    @Override
    public int sumRange(int left, int right) {
        if (left > 0)
            return sumsSoFar[right] - sumsSoFar[left - 1];
        else
            return sumsSoFar[right];
    }

    @Override
    public void setArray(int[] nums) {
        sumsSoFar = new int[nums.length];
        sumsSoFar[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sumsSoFar[i] = nums[i] + sumsSoFar[i - 1];
        }
    }
}
