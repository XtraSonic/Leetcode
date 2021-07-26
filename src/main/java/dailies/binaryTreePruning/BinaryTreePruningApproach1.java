package dailies.binaryTreePruning;

import commonUtilities.TreeNode;

public class BinaryTreePruningApproach1 implements BinaryTreePruning {
    @Override
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newLeft = pruneTree(root.getLeft());
        TreeNode newRight = pruneTree(root.getRight());
        if (newLeft != null || newRight != null || root.getVal() == 1) {
            return new TreeNode(root.getVal(), newLeft, newRight);
        }
        return null;
    }
}
