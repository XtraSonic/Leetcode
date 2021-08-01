package commonUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatrixIndex {
    public int i;
    public int j;

    public MatrixIndex(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Gets the cardinal (up, down, left, right,) neighbour indexes of a square matrix with length limitMax
     *
     * @param limitMax the size of the square matrix for which to get the neighbours
     * @return list of indexes representing the cardinal neighbours of the current index
     */
    public List<MatrixIndex> getCardinalNeighbours(int limitMax) {
        return getCardinalNeighbours(limitMax, limitMax);
    }

    /**
     * Gets the cardinal (up, down, left, right,) neighbour indexes of an iLimitMax x jLimitMax matrix
     *
     * @param iLimitMax the height of the matrix (length of the first dimension)
     * @param jLimitMax the length of the matrix (length of the second dimension)
     * @return list of indexes representing the cardinal neighbours of the current index
     */
    public List<MatrixIndex> getCardinalNeighbours(int iLimitMax, int jLimitMax) {
        return getCardinalNeighbours(0, iLimitMax, 0, jLimitMax);
    }

    /**
     * Gets the cardinal (up, down, left, right,) neighbour indexes of an matrix
     *
     * @param iLimitMin the minimum value i can have (inclusive)
     * @param iLimitMax the maximum value i can have (exclusive)
     * @param jLimitMin the minimum value j can have (inclusive)
     * @param jLimitMax the maximum value i can have (exclusive)
     * @return list of indexes representing the cardinal neighbours of the current index
     */
    public List<MatrixIndex> getCardinalNeighbours(int iLimitMin, int iLimitMax, int jLimitMin, int jLimitMax) {
        List<MatrixIndex> neighbours = new ArrayList<>();
        if (i - 1 >= iLimitMin) {
            neighbours.add(new MatrixIndex(i - 1, j));
        }
        if (i + 1 < iLimitMax) {
            neighbours.add(new MatrixIndex(i + 1, j));
        }
        if (j - 1 >= jLimitMin) {
            neighbours.add(new MatrixIndex(i, j - 1));
        }
        if (j + 1 < jLimitMax) {
            neighbours.add(new MatrixIndex(i, j + 1));
        }
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixIndex that = (MatrixIndex) o;
        return i == that.i && j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
