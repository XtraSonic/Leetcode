package dailies.addStrings;

public class AddStringsApproach1 implements AddStrings {

    @Override
    public String addStrings(String num1, String num2) {
        String result;
        if (num1.length() >= num2.length())
            result = addStrings(num1, num2, 0);
        else
            result = addStrings(num2, num1, 0);
        return result;
    }

    private String addStrings(String a, String b, int carry) {
        if (b.isEmpty() && carry == 0) {
            return a;
        }

        if (a.isEmpty()) {
            return "1";
        }


        int endIndexOfA = a.length() - 1;
        char lastDigit = a.charAt(endIndexOfA);
        int endIndexOfB = 0;
        if (!b.isEmpty()) {
            endIndexOfB = b.length() - 1;
            // a is already a char so when adding b which is also a char,
            // we need to subtract the value of the '0' char to get the real value of b
            lastDigit += b.charAt(endIndexOfB);
            lastDigit -= '0';
        }
        lastDigit += carry;
        int newCarry = 0;
        if (lastDigit > '9') {
            lastDigit -= 10;
            newCarry = 1;
        }
        return addStrings(a.substring(0, endIndexOfA), b.substring(0, endIndexOfB), newCarry) + lastDigit;
    }
}
