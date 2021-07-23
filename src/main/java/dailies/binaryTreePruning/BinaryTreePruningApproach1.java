package dailies.binaryTreePruning;

public class BinaryTreePruningApproach1 implements BinaryTreePruning {
    @Override
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newLeft = pruneTree(root.left);
        TreeNode newRight = pruneTree(root.right);
        if (newLeft != null || newRight != null || root.val == 1) {
            return new TreeNode(root.val, newLeft, newRight);
        }
        return null;
    }
}
