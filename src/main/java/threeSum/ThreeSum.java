package threeSum;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triplets> results = new HashSet<>();

        Set<Integer> seenNumbers = new HashSet<>();
        Map<Integer, Set<Tuple>> pendingResults = new HashMap<>();

        for (int currentNumber : nums) {
            if (pendingResults.containsKey(currentNumber)) {
                //found a key that will complete these items so we store them as results
                Set<Tuple> tuples = pendingResults.get(currentNumber);
                for (Iterator<Tuple> it = tuples.iterator(); it.hasNext(); ) {
                    Tuple partialResult = it.next();
                    results.add(partialResult.makeTriplet(currentNumber));
                    it.remove();
                }
            }

            for (int seenNumber : seenNumbers) {
                int expectedNumber = -seenNumber - currentNumber;
                Set<Tuple> tupleSet;
                if (pendingResults.containsKey(expectedNumber)) {
                    tupleSet = pendingResults.get(expectedNumber);
                    tupleSet.add(new Tuple(seenNumber, currentNumber));
                } else {
                    tupleSet = new HashSet<>();
                    tupleSet.add(new Tuple(seenNumber, currentNumber));
                    pendingResults.put(expectedNumber, tupleSet);
                }
            }

            seenNumbers.add(currentNumber);
        }

        return results.stream().map(Triplets::toList).collect(Collectors.toList());
    }

    public static class Tuple {
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

        public Triplets makeTriplet(int c) {
            return new Triplets(small, big, c);
        }
    }

    public static class Triplets {
        int size1;
        int size2;
        int size3;

        Triplets(int a, int b, int c) {
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
            Triplets triplets = (Triplets) o;
            return size1 == triplets.size1 && size2 == triplets.size2 && size3 == triplets.size3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(size1, size2, size3);
        }
    }
}
