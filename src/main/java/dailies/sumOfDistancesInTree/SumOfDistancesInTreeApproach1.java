package dailies.sumOfDistancesInTree;

import java.util.LinkedList;
import java.util.List;

public class SumOfDistancesInTreeApproach1 implements SumOfDistancesInTree {

    @Override
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }
        for (int[] edge : edges) {
            TreeNode nodeA = nodes[edge[0]];
            TreeNode nodeB = nodes[edge[1]];
            nodeA.children.add(nodeB);
            nodeB.children.add(nodeA);
        }
        TreeNode root = nodes[0];
        setParentChildRelation(root);
        int[] result = new int[n];
        calculateDistanceToAll(root, result);
        return result;
    }

    private void calculateDistanceToAll(TreeNode node, int[] result) {
        if (node.parent == null) {
            result[node.val] = node.distanceToChildren;
        } else {
            result[node.val] = result[node.parent.val] + result.length - 2 * node.totalNumberOfChildren - 2;
        }
        node.children.forEach(child -> calculateDistanceToAll(child, result));
    }

    private void setParentChildRelation(TreeNode node) {
        if (node == null)
            return;
        node.totalNumberOfChildren += node.children.size();
        node.children.forEach(child -> {
            if (child == node)
                return;
            child.children.remove(node);
            child.parent = node;
            setParentChildRelation(child);
            node.totalNumberOfChildren += child.totalNumberOfChildren;
            node.distanceToChildren += 1 + child.distanceToChildren + child.totalNumberOfChildren;
        });

    }

    private static class TreeNode {
        int val;
        int totalNumberOfChildren;
        int distanceToChildren;
        List<TreeNode> children;
        TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
            children = new LinkedList<>();
        }
    }
}
