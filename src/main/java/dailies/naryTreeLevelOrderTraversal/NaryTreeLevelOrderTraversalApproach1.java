package dailies.naryTreeLevelOrderTraversal;

import commonUtilities.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversalApproach1 implements NaryTreeLevelOrderTraversal {

    @Override
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int childrenOnThisLevel = queue.size();
            List<Integer> valuesOnThisLevel = new ArrayList<>();
            while (childrenOnThisLevel > 0) {
                childrenOnThisLevel--;
                Node currentNode = queue.poll();
                valuesOnThisLevel.add(currentNode.val);
                queue.addAll(currentNode.children);
            }
            result.add(valuesOnThisLevel);
        }
        return result;
    }
}
