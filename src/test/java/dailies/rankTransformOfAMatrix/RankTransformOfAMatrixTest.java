package dailies.rankTransformOfAMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class RankTransformOfAMatrixTest {
    RankTransformOfAMatrix rankTransformOfAMatrix;

    @Test
    void testExample1() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {1, 2},
                {2, 3}
        }, new int[][]{
                {1, 2},
                {3, 4}
        });
    }

    private void evaluateRankTransformOfAMatrix(int[][] expected, int[][] matrix) {
        assertArrayEquals(expected, rankTransformOfAMatrix.matrixRankTransform(matrix));
    }

    @Test
    void testExample2() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {1, 1},
                {1, 1}
        }, new int[][]{
                {7, 7},
                {7, 7}
        });
    }


    @Test
    void testExample3() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {4, 2, 3},
                {1, 3, 4},
                {5, 1, 6},
                {1, 3, 4}
        }, new int[][]{
                {20, -21, 14},
                {-19, 4, 19},
                {22, -47, 24},
                {-19, 4, 19}
        });
    }

    @Test
    void testExample4() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {5, 1, 4},
                {1, 2, 3},
                {6, 3, 1}
        }, new int[][]{
                {7, 3, 6},
                {1, 4, 5},
                {9, 8, 2}
        });
    }

    @Test
    void testLineMatrix() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {1, 5, 3, 2, 6, 4}
        }, new int[][]{
                {1, 5, 3, 2, 6, 4}
        });
    }

    @Test
    void testVerticalMatrix() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {5},
                {3},
                {1},
                {2},
                {6},
                {4}
        }, new int[][]{
                {5},
                {3},
                {1},
                {2},
                {6},
                {4}
        });
    }

    @Test
    void testOneElementMatrix() {
        evaluateRankTransformOfAMatrix(new int[][]{
                {1}
        }, new int[][]{
                {5}
        });
    }
}
