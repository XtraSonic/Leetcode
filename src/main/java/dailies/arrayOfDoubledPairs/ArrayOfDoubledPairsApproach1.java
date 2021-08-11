package dailies.arrayOfDoubledPairs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ArrayOfDoubledPairsApproach1 implements ArrayOfDoubledPairs {

    @Override
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> oddNumberDoubles = new HashMap<>();
        HashMap<Integer, Integer> evenNumbers = new HashMap<>();

        for (Integer currentValue : arr) {
            if (currentValue % 2 == 0) {
                if (oddNumberDoubles.containsKey(currentValue)) {
                    Integer frequency = oddNumberDoubles.get(currentValue);
                    if (frequency > 1) {
                        oddNumberDoubles.put(currentValue, frequency - 1);
                    } else {
                        oddNumberDoubles.remove(currentValue);
                    }
                } else {
                    if (evenNumbers.containsKey(currentValue)) {
                        evenNumbers.put(currentValue, evenNumbers.get(currentValue) + 1);
                    } else {
                        evenNumbers.put(currentValue, 1);
                    }
                }
            } else {
                int doubleOfTheCurrentValue = currentValue * 2;
                if (evenNumbers.containsKey(doubleOfTheCurrentValue)) {
                    Integer frequency = evenNumbers.get(doubleOfTheCurrentValue);
                    if (frequency > 1) {
                        evenNumbers.put(doubleOfTheCurrentValue, frequency - 1);
                    } else {
                        evenNumbers.remove(doubleOfTheCurrentValue);
                    }
                } else {
                    if (oddNumberDoubles.containsKey(doubleOfTheCurrentValue)) {
                        oddNumberDoubles.put(doubleOfTheCurrentValue, oddNumberDoubles.get(doubleOfTheCurrentValue) + 1);
                    } else {
                        oddNumberDoubles.put(doubleOfTheCurrentValue, 1);
                    }
                }
            }
        }

        if (!oddNumberDoubles.isEmpty()) {
            return false;
        }

        List<Integer> sortedIndexes = new ArrayList<>(evenNumbers.keySet());
        sortedIndexes.sort(Comparator.comparingInt(e -> e));

        for (int index : sortedIndexes) {
            int frequencyOfLowestNumber = evenNumbers.get(index);
            if (frequencyOfLowestNumber == 0)
                continue;

            int doubleOfTheCurrentNumber;
            if (index < 0) {
                doubleOfTheCurrentNumber = index / 2;
            } else {
                doubleOfTheCurrentNumber = index * 2;
            }
            if (evenNumbers.containsKey(doubleOfTheCurrentNumber)) {
                int frequencyOfTheDouble = evenNumbers.get(doubleOfTheCurrentNumber);
                if (frequencyOfLowestNumber <= frequencyOfTheDouble) {
                    evenNumbers.put(doubleOfTheCurrentNumber, frequencyOfTheDouble - frequencyOfLowestNumber);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
