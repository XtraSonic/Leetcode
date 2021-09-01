package dailies.maximumAverageSubtree;

import commonUtilities.TreeNode;

public class MaximumAverageSubtreeApproach1 implements MaximumAverageSubtree {

    @Override
    public double maximumAverageSubtree(TreeNode root) {
        return MaxAverageCalculator.calculateAverage(root).maxAverage;
    }

    static class MaxAverageCalculator {
        double maxAverage;
        int numberOfNodes;
        int sum;

        public MaxAverageCalculator(double maxAverage, int numberOfNodes, int sum) {
            this.maxAverage = maxAverage;
            this.numberOfNodes = numberOfNodes;
            this.sum = sum;
        }

        public static MaxAverageCalculator calculateAverage(TreeNode node) {
            if (node == null)
                return new MaxAverageCalculator(0, 0, 0);
            MaxAverageCalculator left = calculateAverage(node.left);
            MaxAverageCalculator right = calculateAverage(node.right);
            int currentSum = left.sum + right.sum + node.val;
            int currentNumberOfNodes = left.numberOfNodes + right.numberOfNodes + 1;
            double currentMaxAverage = Math.max(Math.max(left.maxAverage, right.maxAverage), (double) currentSum / currentNumberOfNodes);
            return new MaxAverageCalculator(currentMaxAverage, currentNumberOfNodes, currentSum);
        }
    }
}
