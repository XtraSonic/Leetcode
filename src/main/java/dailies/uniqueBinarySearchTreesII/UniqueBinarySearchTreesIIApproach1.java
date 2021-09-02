package dailies.uniqueBinarySearchTreesII;

import commonUtilities.TreeNode;

import java.util.*;

public class UniqueBinarySearchTreesIIApproach1 implements UniqueBinarySearchTreesII {

    @Override
    public List<TreeNode> generateTrees(int n) {
        Set<TreeNode> result = new HashSet<>();
        int[] numbers = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
            indexes[i] = 0;
        }
        result.add(new BST(numbers).root);

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                if (i % 2 == 0) {
                    int tmp = numbers[0];
                    numbers[0] = numbers[i];
                    numbers[i] = tmp;
                } else {

                    int tmp = numbers[indexes[i]];
                    numbers[indexes[i]] = numbers[i];
                    numbers[i] = tmp;
                }
                result.add(new BST(numbers).root);
                indexes[i]++;
                i = 1;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        return new ArrayList<>(result);
    }

    class BST {
        TreeNode root;

        public BST(int[] numbers) {
            this.root = new TreeNode(numbers[0]);
            insert(Arrays.copyOfRange(numbers, 1, numbers.length));
        }

        public BST(int numbers) {
            this.root = new TreeNode(numbers);
        }

        void insert(int[] numbers) {
            for (int number : numbers) {
                insert(number);
            }
        }

        void insert(int number) {
            TreeNode parent = root;
            TreeNode currentNode;
            if (parent.val < number) {
                currentNode = parent.right;
            } else {
                currentNode = parent.left;
            }
            while (currentNode != null) {
                if (parent.val < number) {
                    parent = currentNode;
                    currentNode = parent.right;
                } else {
                    parent = currentNode;
                    currentNode = parent.left;
                }
            }
            if (parent.val < number) {
                parent.right = new TreeNode(number);
            } else {
                parent.left = new TreeNode(number);
            }
        }
    }
}
