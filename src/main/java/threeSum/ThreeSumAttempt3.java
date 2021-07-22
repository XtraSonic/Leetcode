package threeSum;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumAttempt3 implements ThreeSum {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triplet> results = new HashSet<>();

        Map<Integer, Integer> seenNumbers = new HashMap<>();

        for (int currentNumber : nums) {
            Set<Integer> seenNumbersSet = seenNumbers.keySet();
            for (int seenNumber : seenNumbersSet) {
                int expectedNumber = -seenNumber - currentNumber;
                if (seenNumbersSet.contains(expectedNumber)) {
                    if (expectedNumber == seenNumber && expectedNumber == currentNumber) {
                        //this is the a+a+a = 0 case (aka 0,0,0)
                        //In order to have a solution, we need to have seen the expected number twice before and this
                        // will be out third time seeing it (since currentNumber = expectedNumber = seenNumber)
                        if (seenNumbers.get(expectedNumber) >= 2) {
                            // but for it to be a solution, it must have been seen at least twice before (this is the 0,0,0 case)
                            results.add(new Triplet(expectedNumber, seenNumber, currentNumber));
                        }
                    } else if (expectedNumber == seenNumber) {
                        //We have the a + a + b = 0 case which means we need to see a twice to have a solution
                        //Since we have not registered the current number yet,
                        // if  expectedNumber = currentNumber, => a = currentNumber and since we know
                        // the expected number (the second a) and the seen number (b) have already been seen,
                        // we have all the values, but if expectedNumber = seenNumber => b = currentNumber and
                        // we need to make sure we saw a at least 2 times before
                        if (seenNumbers.get(expectedNumber) >= 2) {
                            results.add(new Triplet(expectedNumber, seenNumber, currentNumber));
                        }
                    } else {
                        //each number was seen at least 1 time which is enough
                        results.add(new Triplet(expectedNumber, seenNumber, currentNumber));
                    }
                }
            }

            int frequency;
            if (seenNumbers.containsKey(currentNumber)) {
                frequency = seenNumbers.get(currentNumber) + 1;
            } else {
                frequency = 1;
            }
            seenNumbers.put(currentNumber, frequency);
        }

        return results.stream().map(Triplet::toList).collect(Collectors.toList());
    }
}
