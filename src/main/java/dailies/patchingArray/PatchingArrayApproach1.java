package dailies.patchingArray;

import java.util.HashSet;

public class PatchingArrayApproach1 implements PatchingArray {

    @Override
    public int minPatches(int[] nums, int n) {

        HashSet<Integer> numbersInInterval = new HashSet<>();

        for (int currentNumber : nums) {
            insertNumber(currentNumber, numbersInInterval, n);
        }

        int numberOfPatches = 0;
        int index = 1;
        while (index <= n) {
            //find first number not in interval
            while (numbersInInterval.contains(index)) {
                index++;
                if (index > n) {
                    return numberOfPatches;
                }
            }

            insertNumber(index, numbersInInterval, n);
            numberOfPatches++;
            index++;
        }

        return numberOfPatches;
    }

    private void insertNumber(int numberToInsert, HashSet<Integer> numbersInInterval, int maxN) {
        HashSet<Integer> newNumbers = new HashSet<>();
        numbersInInterval.forEach(number -> {
            int newNumber = number + numberToInsert;
            if (newNumber <= maxN)
                newNumbers.add(newNumber);
        });
        numbersInInterval.add(numberToInsert);
        numbersInInterval.addAll(newNumbers);

    }

}
