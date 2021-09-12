package dailies.reachableNodesInSubdividedGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ReachableNodesInSubdividedGraphTest {
    ReachableNodesInSubdividedGraph reachableNodesInSubdividedGraph;

    @Test
    void testExample1() {
        assertEquals(13, reachableNodesInSubdividedGraph.reachableNodes(new int[][]{
                new int[]{0, 1, 10},
                new int[]{0, 2, 1},
                new int[]{1, 2, 2},
        }, 6, 3));
    }

    @Test
    void testExample2() {

        assertEquals(23, reachableNodesInSubdividedGraph.reachableNodes(new int[][]{
                new int[]{0, 1, 4},
                new int[]{1, 2, 6},
                new int[]{0, 2, 8},
                new int[]{1, 3, 1}
        }, 10, 4));
    }

    @Test
    void testExample3() {

        assertEquals(1, reachableNodesInSubdividedGraph.reachableNodes(new int[][]{
                new int[]{1, 2, 4},
                new int[]{1, 4, 5},
                new int[]{1, 3, 1},
                new int[]{2, 3, 4},
                new int[]{3, 4, 5},
        }, 17, 5));
    }


}
