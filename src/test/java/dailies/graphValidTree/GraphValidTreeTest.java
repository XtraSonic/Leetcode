package dailies.graphValidTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class GraphValidTreeTest {
    GraphValidTree graphValidTree;

    @Test
    void testExample1() {
        assertTrue(graphValidTree.validTree(5, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{0, 4},
        }));
    }

    @Test
    void testExample2() {
        assertFalse(graphValidTree.validTree(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{1, 4},
        }));
    }

    @Test
    void testIsolatedNode() {
        assertFalse(graphValidTree.validTree(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{0, 4},
        }));
    }

    @Test
    void testJoinMultipleNodesLast() {
        assertTrue(graphValidTree.validTree(4, new int[][]{
                new int[]{0, 1},
                new int[]{2, 3},
                new int[]{1, 2}
        }));
    }
}
