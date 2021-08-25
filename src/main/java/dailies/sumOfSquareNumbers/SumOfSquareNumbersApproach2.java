package dailies.sumOfSquareNumbers;

public class SumOfSquareNumbersApproach2 implements SumOfSquareNumbers {
    @Override
    public boolean judgeSquareSum(int c) {
        int number = (int) Math.floor(Math.sqrt(c));
        int otherNumberSquared;
        int otherNumber;
        do {
            otherNumberSquared = c - number * number;
            otherNumber = (int) Math.floor(Math.sqrt(otherNumberSquared));
            if (otherNumberSquared == otherNumber * otherNumber) {
                return true;
            }
            number--;
        } while (otherNumber < number);

        return false;
    }
}
