package threeSum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tuple {
    int small;
    int big;

    Tuple(int a, int b) {
        if (a < b) {
            small = a;
            big = b;
        } else {
            small = b;
            big = a;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return small == tuple.small && big == tuple.big;
    }

    @Override
    public int hashCode() {
        return Objects.hash(small, big);
    }

    public List<Integer> toList() {
        return Arrays.asList(small, big);
    }

    public Triplet makeTriplet(int c) {
        return new Triplet(small, big, c);
    }
}
