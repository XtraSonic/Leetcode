package dailies.sumOfSquareNumbers;

import java.util.HashSet;

public class SumOfSquareNumbersApproach1 implements SumOfSquareNumbers {

    @Override
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.floor(Math.sqrt(c));
        HashSet<Integer> squares = new HashSet<>();
        for (int i = 0; i <= sqrt; i++) {
            int iSquared = i * i;
            int target = c - iSquared;
            squares.add(iSquared);
            if (squares.contains(target))
                return true;
        }
        return false;
    }
}
