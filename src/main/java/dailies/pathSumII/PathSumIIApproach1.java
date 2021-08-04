package dailies.pathSumII;

import commonUtilities.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIIApproach1 implements PathSumII {

    @Override
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        searchInDepth(root, result, new LinkedList<>(), targetSum);
        return result;
    }

    private void searchInDepth(TreeNode root, List<List<Integer>> result, LinkedList<Integer> currentPath, int targetSum) {
        if (root == null)
            return;
        targetSum -= root.val;
        currentPath.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            searchInDepth(root.left, result, currentPath, targetSum);
            searchInDepth(root.right, result, currentPath, targetSum);
        }
        currentPath.removeLast();
    }
}
