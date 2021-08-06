package commonUtilities;

import java.util.*;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node createFromArray(Integer... values) {
        Iterator<Integer> iterator = Arrays.stream(values).iterator();
        if (!iterator.hasNext())
            return null;
        Node root = new Node(iterator.next());
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        if (!iterator.hasNext())
            return root;
        if (iterator.next() != null) {
            throw new IllegalArgumentException("The input array must contain one null after the root element");
        }
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            List<Node> list = new ArrayList<>();
            Integer val;
            do {
                if (iterator.hasNext())
                    val = iterator.next();
                else
                    val = null;
                Node child;
                if (val != null) {
                    child = new Node(val);
                    queue.add(child);
                    list.add(child);
                }
            } while (val != null);
            currentNode.children = list;
        }
        return root;
    }
}
