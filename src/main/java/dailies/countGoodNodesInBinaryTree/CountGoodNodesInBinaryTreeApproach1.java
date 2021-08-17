package dailies.countGoodNodesInBinaryTree;

import commonUtilities.TreeNode;

public class CountGoodNodesInBinaryTreeApproach1 implements CountGoodNodesInBinaryTree {

    @Override
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode root, int highestNodeSoFar) {
        int goodNodes = 0;
        if (root == null)
            return 0;
        if (root.val >= highestNodeSoFar) {
            goodNodes++;
            highestNodeSoFar = root.val;
        }
        goodNodes += countGoodNodes(root.left, highestNodeSoFar);
        goodNodes += countGoodNodes(root.right, highestNodeSoFar);
        return goodNodes;
    }
}
