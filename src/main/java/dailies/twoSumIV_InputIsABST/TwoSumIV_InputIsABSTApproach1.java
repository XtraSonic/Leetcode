package dailies.twoSumIV_InputIsABST;

import commonUtilities.TreeNode;

import java.util.HashSet;

public class TwoSumIV_InputIsABSTApproach1 implements TwoSumIV_InputIsABST {

    HashSet<Integer> seenIntegers;

    @Override
    public boolean findTarget(TreeNode root, int k) {
        seenIntegers = new HashSet<>();
        return findTwoSum(root, k);
    }

    public boolean findTwoSum(TreeNode node, int k) {
        if (node == null)
            return false;
        int neededValue = k - node.val;
        if (seenIntegers.contains(neededValue))
            return true;
        seenIntegers.add(node.val);
        if (findTwoSum(node.left, k)) {
            return true;
        }
        return findTwoSum(node.right, k);
    }
}
