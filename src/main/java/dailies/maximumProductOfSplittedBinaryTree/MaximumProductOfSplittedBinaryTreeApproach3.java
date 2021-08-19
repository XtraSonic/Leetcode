package dailies.maximumProductOfSplittedBinaryTree;

import commonUtilities.TreeNode;

public class MaximumProductOfSplittedBinaryTreeApproach3 implements MaximumProductOfSplittedBinaryTree {
    @Override
    public int maxProduct(TreeNode root) {
        int totalSum = getSumOfTree(root);
        TreeMaxProduct tmp = new TreeMaxProduct();
        return tmp.getMaxProduct(root, totalSum);
    }

    private int getSumOfTree(TreeNode node) {
        if (node == null)
            return 0;
        return getSumOfTree(node.left) + getSumOfTree(node.right) + node.val;
    }

    static class TreeMaxProduct {
        long maxProduct;
        int totalSum;

        public int getMaxProduct(TreeNode root, int totalSum) {
            this.totalSum = totalSum;
            getSumOfSubtreeWithSettingMaxProduct(root);
            return (int) (maxProduct % 1000000007);
        }

        public int getSumOfSubtreeWithSettingMaxProduct(TreeNode node) {
            int sumLeft = 0;
            if (node.left != null) {
                sumLeft = getSumOfSubtreeWithSettingMaxProduct(node.left);
                maxProduct = Math.max(maxProduct, ((long) sumLeft * (totalSum - sumLeft)));
            }
            int sumRight = 0;
            if (node.right != null) {
                sumRight = getSumOfSubtreeWithSettingMaxProduct(node.right);
                maxProduct = Math.max(maxProduct, ((long) sumRight * (totalSum - sumRight)));
            }
            return sumLeft + sumRight + node.val;
        }
    }
}
