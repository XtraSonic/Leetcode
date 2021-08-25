package dailies.sumOfSquareNumbers;

import java.util.HashSet;

public class SumOfSquareNumbersApproach1 implements SumOfSquareNumbers {

    @Override
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.floor(Math.sqrt(c));
        int[] squares = new int[sqrt + 1];
        for (int i = 0; i <= sqrt; i++) {
            squares[i] = i * i;
        }
        return canTowSum(squares, c);
    }

    private boolean canTowSum(int[] squares, int c) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        for (int square : squares) {
            int target = c - square;
            seenNumbers.add(square);
            if (seenNumbers.contains(target))
                return true;
        }
        return false;
    }
}
