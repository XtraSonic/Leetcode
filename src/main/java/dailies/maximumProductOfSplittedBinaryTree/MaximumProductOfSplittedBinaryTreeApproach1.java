package dailies.maximumProductOfSplittedBinaryTree;

import commonUtilities.TreeNode;

import java.util.HashMap;

public class MaximumProductOfSplittedBinaryTreeApproach1 implements MaximumProductOfSplittedBinaryTree {

    @Override
    public int maxProduct(TreeNode root) {
        HashMap<TreeNode, Integer> subtreeSumMap = new HashMap<>();
        setSumMap(root, subtreeSumMap);
        TreeMaxProduct tmp = new TreeMaxProduct();
        return tmp.getMaxProduct(root, subtreeSumMap);
    }

    private void setSumMap(TreeNode node, HashMap<TreeNode, Integer> subtreeSumMap) {
        int sumLeft = 0;
        int sumRight = 0;

        if (node.left != null) {
            setSumMap(node.left, subtreeSumMap);
            sumLeft = subtreeSumMap.get(node.left);
        }
        if (node.right != null) {
            setSumMap(node.right, subtreeSumMap);
            sumRight = subtreeSumMap.get(node.right);
        }
        subtreeSumMap.put(node, sumLeft + sumRight + node.val);

    }

    static class TreeMaxProduct {
        int maxMultiplicationRemainder;
        int numberOf1000000007s;
        HashMap<TreeNode, Integer> subtreeSumMap;
        int totalSum;

        public int getMaxProduct(TreeNode root, HashMap<TreeNode, Integer> subtreeSumMap) {
            this.subtreeSumMap = subtreeSumMap;
            maxMultiplicationRemainder = 0;
            numberOf1000000007s = 0;
            totalSum = subtreeSumMap.get(root);
            compareSumForMaxProduct(root);

            return maxMultiplicationRemainder;
        }

        public void compareSumForMaxProduct(TreeNode node) {
            if (node.left != null) {
                int sumLeft = subtreeSumMap.get(node.left);
                setMaxProductSoFar(sumLeft, totalSum - sumLeft);
                compareSumForMaxProduct(node.left);
            }

            if (node.right != null) {
                int sumRight = subtreeSumMap.get(node.right);
                setMaxProductSoFar(sumRight, totalSum - sumRight);
                compareSumForMaxProduct(node.right);
            }
        }


        private void setMaxProductSoFar(int a, int b) {
            int remainder = 0;
            int countOf1000000007s = 0;
            int min;
            int max;
            if (a < b) {
                min = a;
                max = b;
            } else {
                min = b;
                max = a;
            }
            for (int i = 0; i < min; i++) {
                remainder = (remainder + max);
                if (remainder > 1000000007) {
                    remainder -= 1000000007;
                    countOf1000000007s++;
                }
            }

            if (countOf1000000007s > numberOf1000000007s || ((countOf1000000007s == numberOf1000000007s && maxMultiplicationRemainder < remainder))) {
                numberOf1000000007s = countOf1000000007s;
                maxMultiplicationRemainder = remainder;
            }

        }
    }
}
