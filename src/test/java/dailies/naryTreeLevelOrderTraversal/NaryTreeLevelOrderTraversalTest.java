package dailies.naryTreeLevelOrderTraversal;

import commonUtilities.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class NaryTreeLevelOrderTraversalTest {
    NaryTreeLevelOrderTraversal naryTreeLevelOrderTraversal;

    @Test
    void testExample1() {
        evaluateNaryTreeLevelOrderTraversal(asList(
                asList(1),
                asList(3, 2, 4),
                asList(5, 6)
        ), 1, null, 3, 2, 4, null, 5, 6);
    }

    @Test
    void testExample2() {
        evaluateNaryTreeLevelOrderTraversal(asList(
                asList(1),
                asList(2, 3, 4, 5),
                asList(6, 7, 8, 9, 10),
                asList(11, 12, 13),
                asList(14)
        ), 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14);
    }

    private void evaluateNaryTreeLevelOrderTraversal(List<List<Integer>> expected, Integer... treeInArrayForm) {
        assertEquals(expected, naryTreeLevelOrderTraversal.levelOrder(Node.createFromArray(
                treeInArrayForm)));
    }

    @Test
    void testEmptyTree() {
        evaluateNaryTreeLevelOrderTraversal(asList());
    }
}
