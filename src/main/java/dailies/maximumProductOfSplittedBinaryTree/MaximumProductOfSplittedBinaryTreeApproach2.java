package dailies.maximumProductOfSplittedBinaryTree;

import commonUtilities.TreeNode;

import java.util.HashMap;

public class MaximumProductOfSplittedBinaryTreeApproach2 implements MaximumProductOfSplittedBinaryTree {
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
        int parabolaVertex;
        int maxXBeforeVertex;
        HashMap<TreeNode, Integer> subtreeSumMap;
        int totalSum;

        public int getMaxProduct(TreeNode root, HashMap<TreeNode, Integer> subtreeSumMap) {
            this.subtreeSumMap = subtreeSumMap;
            maxXBeforeVertex = 0;
            totalSum = subtreeSumMap.get(root);

            // the parabola is x*(totalSum -x) = -x^2 + totalSum * x
            // the vertex is -b/(2*a) => the vertex here is -totalSum/(2*(-1))= totalSum/2
            parabolaVertex = totalSum / 2;
            compareSumForMaxProduct(root);

            int result = 0;
            int multiplied = totalSum - maxXBeforeVertex;
            for (int i = 0; i < maxXBeforeVertex; i++) {
                result = (result + multiplied) % 1000000007;
            }
            return result;
        }

        public void compareSumForMaxProduct(TreeNode node) {
            if (node.left != null) {
                int sumLeft = subtreeSumMap.get(node.left);
                setMaxXBeforeVertex(sumLeft);
                compareSumForMaxProduct(node.left);
            }

            if (node.right != null) {
                int sumRight = subtreeSumMap.get(node.right);
                setMaxXBeforeVertex(sumRight);
                compareSumForMaxProduct(node.right);
            }
        }


        private void setMaxXBeforeVertex(int a) {
            int x;
            if (a < parabolaVertex) {
                x = a;
            } else {
                x = totalSum - a;
            }
            if (maxXBeforeVertex < x) {
                maxXBeforeVertex = x;
            }
        }
    }
}
