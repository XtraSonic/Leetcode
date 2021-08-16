package dailies.rangeSumQueryImmutable;

import java.util.Arrays;

public class RangeSumQueryImmutableApproach1 implements RangeSumQueryImmutable {

    int[][] precomputedTable;

    public RangeSumQueryImmutableApproach1() {
    }

    public RangeSumQueryImmutableApproach1(int[] nums) {
        setArray(nums);
    }

    @Override
    public int sumRange(int left, int right) {
        return precomputedTable[right][left];
    }

    @Override
    public void setArray(int[] nums) {
        precomputedTable = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            precomputedTable[i] = new int[i + 1];
            precomputedTable[i][i] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                precomputedTable[i][j] = precomputedTable[i - 1][j] + nums[i];
            }
        }
        System.out.println(Arrays.deepToString(precomputedTable));
    }
}
