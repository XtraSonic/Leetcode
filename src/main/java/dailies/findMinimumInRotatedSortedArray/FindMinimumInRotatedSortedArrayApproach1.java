package dailies.findMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArrayApproach1 implements FindMinimumInRotatedSortedArray {

    @Override
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int center = (right - left) / 2 + left;
        if (nums[left] < nums[center]) {
            if (nums[right] < nums[center]) {
                return findMin(nums, center + 1, right);
            } else {
                return findMin(nums, left, center - 1);
            }
        } else {
            if (nums[right] > nums[center]) {
                return findMin(nums, left, center);
            } else {
                return findMin(nums, center + 1, right);
            }
        }
    }
}
