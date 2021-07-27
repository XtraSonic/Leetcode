package dailies.convertSortedArrayToBinarySearchTree;

import commonUtilities.TreeNode;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTreeApproach1 implements ConvertSortedArrayToBinarySearchTree {

    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        if (nums.length == 1)
            return new TreeNode(nums[0]);
        int middleIndex = nums.length / 2;
        int[] leftArray = Arrays.copyOfRange(nums, 0, middleIndex);
        int[] rightArray = Arrays.copyOfRange(nums, middleIndex + 1, nums.length);
        return new TreeNode(nums[middleIndex], sortedArrayToBST(leftArray), sortedArrayToBST(rightArray));
    }
}
