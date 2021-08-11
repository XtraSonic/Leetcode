package dailies.arrayOfDoubledPairs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayOfDoubledPairsApproach1 implements ArrayOfDoubledPairs {

    @Override
    public boolean canReorderDoubled(int[] arr) {
        List<Integer> oddNumberDoubles = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (int currentValue : arr) {
            if (currentValue % 2 == 0) {
                if (oddNumberDoubles.contains(currentValue)) {
                    oddNumberDoubles.remove(Integer.valueOf(currentValue));
                } else {
                    evenNumbers.add(currentValue);
                }
            } else {
                int doubleOfTheCurrentValue = currentValue * 2;
                if (evenNumbers.contains(doubleOfTheCurrentValue)) {
                    evenNumbers.remove(Integer.valueOf(doubleOfTheCurrentValue));
                } else {
                    oddNumberDoubles.add(doubleOfTheCurrentValue);
                }
            }
        }

        if (!oddNumberDoubles.isEmpty() || evenNumbers.size() % 2 != 0) {
            return false;
        }

        evenNumbers.sort(Comparator.comparingInt(e -> e));

        while (!evenNumbers.isEmpty()) {
            Integer currentValue = evenNumbers.get(0);
            evenNumbers.remove(currentValue);
            Integer doubleOfTheCurrentNumber;
            if (currentValue < 0) {
                doubleOfTheCurrentNumber = currentValue / 2;
            } else {
                doubleOfTheCurrentNumber = currentValue * 2;
            }
            if (evenNumbers.contains(doubleOfTheCurrentNumber)) {
                evenNumbers.remove(doubleOfTheCurrentNumber);
            } else {
                return false;
            }
        }
        return true;
    }
}
