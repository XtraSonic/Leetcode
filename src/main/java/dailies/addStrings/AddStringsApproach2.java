package dailies.addStrings;

public class AddStringsApproach2 implements AddStrings {
    @Override
    public String addStrings(String num1, String num2) {
        int lastIndexOfA = num1.length() - 1;
        int lastIndexOfB = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        do {
            char lastChar = '0';
            if (lastIndexOfA >= 0) {
                lastChar += num1.charAt(lastIndexOfA) - '0';
            }
            if (lastIndexOfB >= 0) {
                lastChar += num2.charAt(lastIndexOfB) - '0';
            }
            lastChar += carry;
            if (lastChar > '9') {
                lastChar -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.insert(0, lastChar);
            lastIndexOfA--;
            lastIndexOfB--;
        } while (carry > 0 || lastIndexOfA >= 0 || lastIndexOfB >= 0);
        return result.toString();
    }
}
