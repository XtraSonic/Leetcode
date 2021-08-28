package dailies.graphValidTree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphValidTreeApproach1 implements GraphValidTree {

    @Override
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, Integer> nodeToTreeLabelMap = new HashMap<>();
        HashMap<Integer, List<Integer>> treeLabelToNodesMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nodeToTreeLabelMap.put(i, i);
            LinkedList<Integer> listOfNodes = new LinkedList<>();
            listOfNodes.add(i);
            treeLabelToNodesMap.put(i, listOfNodes);
        }

        for (int[] edge : edges) {
            int labelA = nodeToTreeLabelMap.get(edge[0]);
            int labelB = nodeToTreeLabelMap.get(edge[1]);
            if (labelA == labelB)
                return false;
            List<Integer> nodesOfA = treeLabelToNodesMap.get(labelA);
            List<Integer> nodesOfB = treeLabelToNodesMap.get(labelB);
            if (nodesOfA.size() < nodesOfB.size()) {
                nodesOfA.forEach(node -> {
                    nodeToTreeLabelMap.put(node, labelB);
                    nodesOfB.add(node);
                });
                treeLabelToNodesMap.put(labelA, Collections.emptyList());
            } else {
                nodesOfB.forEach(node -> {
                    nodeToTreeLabelMap.put(node, labelA);
                    nodesOfA.add(node);
                });
                treeLabelToNodesMap.put(labelB, Collections.emptyList());
            }
        }

        int label = nodeToTreeLabelMap.get(0);
        return nodeToTreeLabelMap.values().stream().allMatch(e -> e == label);
    }
}
