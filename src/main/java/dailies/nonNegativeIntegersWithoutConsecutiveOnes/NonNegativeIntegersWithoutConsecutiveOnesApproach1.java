package dailies.nonNegativeIntegersWithoutConsecutiveOnes;

public class NonNegativeIntegersWithoutConsecutiveOnesApproach1 implements NonNegativeIntegersWithoutConsecutiveOnes {

    @Override
    public int findIntegers(int n) {

        String numberInBinary = Integer.toBinaryString(n);
        int lengthInBinary = numberInBinary.length();
        int totalNumbers = n + 1;
        int numbersWithConsecutiveOnes = getNumberOfIntegersWithConsecutiveOnes(lengthInBinary - 1) +
                getNumberOfIntegersWithConsecutiveOnes(numberInBinary);
        return totalNumbers - numbersWithConsecutiveOnes;
    }

    //returns the number of numbers with consecutive ones between 2^(lengthInBinary-1) and n
    public int getNumberOfIntegersWithConsecutiveOnes(String numberInBinary) {
        int lengthInBinary = numberInBinary.length();
        if (lengthInBinary < 2)
            return 0;
        if (lengthInBinary == 2)
            return numberInBinary.charAt(1) == '1' ? 1 : 0;
        if (numberInBinary.charAt(1) == '1') {
            int originalNumber = Integer.parseInt(numberInBinary, 2);
            int startOf11 = (int) (Math.pow(2, lengthInBinary - 1) + Math.pow(2, lengthInBinary - 2)); //number 110...

            // n has the form 11.... so everything above 110... will be counted(including the number itself) + the numbers  between 100... and 110..
            int numbersStartingWith11 = originalNumber - startOf11 + 1;
            int numberOfIntegersWithConsecutiveOnesBetween100_and110_ = getNumberOfIntegersWithConsecutiveOnes(lengthInBinary - 2);
            return numbersStartingWith11 + numberOfIntegersWithConsecutiveOnesBetween100_and110_;
        } else {
            // n has the form 10...
            // so the result of this method(1[0]+1...) is equivalent to finding the number of ints with consecutive ones for (1...)
            // so we strip the first 1 and all the 0 after that until we find another 1, we can call this method
            // again which
            String newNumberInBinary = numberInBinary.replaceFirst("1[0]+", "");
            return getNumberOfIntegersWithConsecutiveOnes(newNumberInBinary) + getNumberOfIntegersWithConsecutiveOnes(newNumberInBinary.length() - 1);
        }
    }

    public int getNumberOfIntegersWithConsecutiveOnes(int lengthInBinary) {
        if (lengthInBinary < 2) {
            return 0;
        }

        if (lengthInBinary == 2) {
            return 1;
        }

        if (lengthInBinary == 3) {
            return 3;
        }

        // all the numbers that start with 11... + all the numbers that start with 0... + all the numbers that start with 10...
        return (int) (Math.pow(2, (lengthInBinary - 2)) +
                getNumberOfIntegersWithConsecutiveOnes(lengthInBinary - 1) +
                getNumberOfIntegersWithConsecutiveOnes(lengthInBinary - 2));
    }

}