package threeSum;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumAttempt2 implements ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triplet> results = new HashSet<>();

        Set<Integer> seenNumbers = new HashSet<>();
        Map<Integer, Set<Tuple>> pendingResults = new HashMap<>();
        Set<Tuple> solvedTuples = new HashSet<>();

        for (int currentNumber : nums) {
            if (pendingResults.containsKey(currentNumber)) {
                //found a key that will complete these items so we store them as results
                Set<Tuple> tuples = pendingResults.get(currentNumber);
                for (Iterator<Tuple> it = tuples.iterator(); it.hasNext(); ) {
                    Tuple partialResult = it.next();
                    Triplet solution = partialResult.makeTriplet(currentNumber);
                    results.add(solution);
                    solvedTuples.addAll(solution.getAllTuples());
                    it.remove();
                }
            }

            for (int seenNumber : seenNumbers) {
                int expectedNumber = -seenNumber - currentNumber;
                Set<Tuple> tupleSet;
                Tuple currentTuple = new Tuple(seenNumber, currentNumber);
                if (!solvedTuples.contains(currentTuple)) {
                    if (pendingResults.containsKey(expectedNumber)) {
                        tupleSet = pendingResults.get(expectedNumber);
                        tupleSet.add(currentTuple);
                    } else {
                        tupleSet = new HashSet<>();
                        tupleSet.add(currentTuple);
                        pendingResults.put(expectedNumber, tupleSet);
                    }
                }
            }

            seenNumbers.add(currentNumber);
        }

        return results.stream().map(Triplet::toList).collect(Collectors.toList());
    }
}
