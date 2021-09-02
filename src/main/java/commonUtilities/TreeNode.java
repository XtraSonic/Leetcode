package commonUtilities;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createFromArray(Integer... values) {
        Queue<TreeNode> children = Arrays.stream(values).map(val -> {
            if (val != null)
                return new TreeNode(val);
            else
                return null;
        }).collect(Collectors.toCollection(LinkedList::new));
        List<TreeNode> traversal = new LinkedList<>(children);
        TreeNode root = children.poll();
        for (TreeNode node : traversal)
            if (node != null) {
                node.left = children.poll();
                node.right = children.poll();
            }
        return root;
    }

    public List<Integer> toList() {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                if (queue.stream().anyMatch((Objects::nonNull))) {
                    result.add(null);
                }
            } else {
                result.add(currentNode.val);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return toList().toString();
    }
}
