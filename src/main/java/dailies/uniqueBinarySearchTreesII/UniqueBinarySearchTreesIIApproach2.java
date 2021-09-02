package dailies.uniqueBinarySearchTreesII;

import commonUtilities.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesIIApproach2 implements UniqueBinarySearchTreesII {
    @Override
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        if (left > right) {
            return Collections.emptyList();
        }
        if (left == right) {
            return Collections.singletonList(new TreeNode(left));
        }

        List<TreeNode> result = new LinkedList<>();

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateTrees(left, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, right);
            int val = i;
            if (!leftTrees.isEmpty() && !rightTrees.isEmpty())
                leftTrees.forEach(leftTree -> rightTrees.forEach(rightTree -> result.add(new TreeNode(val, leftTree, rightTree))));
            else {
                if (leftTrees.isEmpty()) {
                    rightTrees.forEach(rightTree -> result.add(new TreeNode(val, null, rightTree)));
                } else {
                    leftTrees.forEach(leftTree -> result.add(new TreeNode(val, leftTree, null)));
                }
            }
        }
        return result;
    }
}
