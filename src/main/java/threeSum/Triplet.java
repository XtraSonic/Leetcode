package threeSum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Triplet {
    int size1;
    int size2;
    int size3;

    Triplet(int a, int b, int c) {
        if (a > b) {
            tripleCompare(b, a, c);
        } else {
            tripleCompare(a, b, c);
        }
    }

    private void tripleCompare(int a, int b, int c) {
        if (b > c) {
            size3 = b;
            if (a > c) {
                size2 = a;
                size1 = c;
            } else {
                size2 = c;
                size1 = a;
            }
        } else {
            size3 = c;
            size2 = b;
            size1 = a;
        }
    }

    public List<Integer> toList() {
        return Arrays.asList(size1, size2, size3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet triplet = (Triplet) o;
        return size1 == triplet.size1 && size2 == triplet.size2 && size3 == triplet.size3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size1, size2, size3);
    }

    public List<Tuple> getAllTuples() {
        return Arrays.asList(new Tuple(size1, size2), new Tuple(size2, size3), new Tuple(size1, size3));
    }
}
