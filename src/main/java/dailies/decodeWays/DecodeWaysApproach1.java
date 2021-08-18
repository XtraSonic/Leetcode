package dailies.decodeWays;

import java.util.HashMap;

public class DecodeWaysApproach1 implements DecodeWays {

    @Override
    public int numDecodings(String s) {
        int totalPossibilities = 1;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if ((currentChar == '1' || currentChar == '2') && i < s.length() - 1) {
                int counterForNumbersWhichMightBeCombined = 0;
                do {
                    counterForNumbersWhichMightBeCombined++;
                    currentChar = s.charAt(++i);
                } while ((currentChar == '1' || currentChar == '2') && i < s.length() - 1);

                if (currentChar == '0' || (currentChar > '6' && s.charAt(i - 1) == '2')) {
                    counterForNumbersWhichMightBeCombined--;
                    if (currentChar == '0' && counterForNumbersWhichMightBeCombined > 0)
                        counterForNumbersWhichMightBeCombined--;
                    currentChar = 'a';//we do not care about this value, all we care about is for it to not be zero

                }
                long powerOfTwo = 1L << counterForNumbersWhichMightBeCombined;
                long numberOfTwoConsecutiveOnes = getNumberOfTwoConsecutiveOnes(counterForNumbersWhichMightBeCombined);
                totalPossibilities *= powerOfTwo - numberOfTwoConsecutiveOnes;
            }

            if (currentChar == '0') {
                return 0;
            }

        }
        return totalPossibilities;
    }


    private HashMap<Integer, Long> partialNumberOfTwoConsecutiveOnes = new HashMap<>();

    private long getNumberOfTwoConsecutiveOnes(int numberOfBits) {
        if (numberOfBits < 2) {
            return 0;
        }
        if (partialNumberOfTwoConsecutiveOnes.containsKey(numberOfBits))
            return partialNumberOfTwoConsecutiveOnes.get(numberOfBits);
        long result = getNumberOfTwoConsecutiveOnes(numberOfBits - 1) + (1L << (numberOfBits - 2)) + getNumberOfTwoConsecutiveOnes(numberOfBits - 2);
        partialNumberOfTwoConsecutiveOnes.put(numberOfBits, result);
        return result;
    }
}
