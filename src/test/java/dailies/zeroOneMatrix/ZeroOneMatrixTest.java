package dailies.zeroOneMatrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class ZeroOneMatrixTest {
    ZeroOneMatrix zeroOneMatrix;

    @Test
    void testExample1() {
        validateMatrixMatch(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                },
                zeroOneMatrix.updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }));
    }

    @Test
    void testExample2() {
        validateMatrixMatch(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 2, 1}
                },
                zeroOneMatrix.updateMatrix(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                }));
    }

    @Test
    void testExampleZeroCenter() {
        validateMatrixMatch(new int[][]{
                        {2, 1, 2},
                        {1, 0, 1},
                        {2, 1, 2}
                },
                zeroOneMatrix.updateMatrix(new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                }));
    }

    @Test
    void testSeparateZeros() {
        validateMatrixMatch(new int[][]{
                        {0, 1, 2},
                        {1, 2, 1},
                        {2, 1, 0}
                },
                zeroOneMatrix.updateMatrix(new int[][]{
                        {0, 1, 1},
                        {1, 1, 1},
                        {1, 1, 0}
                }));
    }


    @Test
    void testHorizontalMatrix() {
        validateMatrixMatch(new int[][]{
                        {0, 1, 2, 3, 2, 1, 0}
                },
                zeroOneMatrix.updateMatrix(new int[][]{
                        {0, 1, 1, 1, 1, 1, 0}
                }));
    }


    @Test
    void testVerticalMatrix() {
        validateMatrixMatch(new int[][]{
                        {0},
                        {1},
                        {2},
                        {3},
                        {2},
                        {1},
                        {0}
                },
                zeroOneMatrix.updateMatrix(new int[][]{
                        {0},
                        {1},
                        {1},
                        {1},
                        {1},
                        {1},
                        {0}
                }));
    }

    public void validateMatrixMatch(int[][] a, int[][] b) {
        int m = a.length;
        int n = a[0].length;
        String stringMatrices = "\na=\n" + toString(a) + "\n\nb=\n" + toString(b);
        if (b.length != m || b[0].length != n) {
            fail("Matrices have different sizes:" + stringMatrices);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    fail("Different values at i:" + i + " j:" + j + stringMatrices);
                }
            }
        }
    }

    public String toString(int[][] a) {
        StringBuilder s = new StringBuilder();
        for (int[] ints : a) {
            s.append(Arrays.toString(ints)).append("\n");
        }
        return s.toString();
    }
}
