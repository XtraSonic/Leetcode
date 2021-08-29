package dailies.patchingArray;

public class PatchingArrayApproach2 implements PatchingArray {
    @Override
    public int minPatches(int[] nums, int n) {
        //nums is sorted
        int patchCount = 0;
        long missingNumber = 1;
        int index = 0;
        while (missingNumber <= n) {
            if (index < nums.length && nums[index] <= missingNumber) {
                missingNumber += nums[index++];
            } else {
                missingNumber += missingNumber;
                patchCount++;
            }
        }
        return patchCount;
    }
}
