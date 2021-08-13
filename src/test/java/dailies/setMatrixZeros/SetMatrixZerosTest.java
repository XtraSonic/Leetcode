package dailies.setMatrixZeros;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SetMatrixZerosTest {
    SetMatrixZeros setMatrixZeros;

    @Test
    void testExample1() {
        evaluateSetZeros(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }, new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });
    }

    @Test
    void testExample2() {
        evaluateSetZeros(new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        }, new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        });
    }

    @Test
    void testCrossingZeros() {

        evaluateSetZeros(new int[][]{
                {1, 0, 0, 3},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 5}
        }, new int[][]{
                {1, 1, 2, 3},
                {3, 0, 5, 2},
                {3, 4, 0, 2},
                {1, 3, 1, 5}
        });
    }

    @Test
    void testNegativeNumbers() {

        evaluateSetZeros(new int[][]{
                {1, 0, 0, 3},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, -5}
        }, new int[][]{
                {1, 1, 2, 3},
                {3, 0, 5, 2},
                {3, 4, 0, 2},
                {1, 3, 1, -5}
        });
    }

    @Test
    void testFirstColumnShouldNotBeZero() {
        evaluateSetZeros(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {2147483647, 2, -9, -6, 0}
        }, new int[][]{
                {-4, -2147483648, 6, -7, 0},
                {-8, 6, -8, -6, 0},
                {2147483647, 2, -9, -6, -10}
        });
    }

    private void evaluateSetZeros(int[][] expected, int[][] matrix) {
        System.out.println("orig:" + Arrays.deepToString(matrix));
        setMatrixZeros.setZeroes(matrix);
        System.out.println("zeros:" + Arrays.deepToString(matrix));
        System.out.println("expected" + Arrays.deepToString(expected));
        assertArrayEquals(expected, matrix);
    }
}
