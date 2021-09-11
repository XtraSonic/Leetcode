package dailies.basicCalculator;

import java.util.Stack;

public class BasicCalculatorApproach1 implements BasicCalculator {

    @Override
    public int calculate(String s) {
        int result = 0;
        boolean add = true;
        boolean shouldInvert = false;
        Stack<Boolean> shouldInvertStack = new Stack<>();
        shouldInvertStack.push(false);
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case ' ':
                    break;
                case '+':
                    add = !shouldInvert;
                    break;
                case '-':
                    add = shouldInvert;
                    break;
                case '(':
                    shouldInvertStack.push(shouldInvert);
                    shouldInvert = !add;
                    break;
                case ')':
                    shouldInvert = shouldInvertStack.pop();
                    break;
            }
            if (currentChar >= '0' && currentChar <= '9') {
                int currentNumber = currentChar - '0';
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    currentNumber = currentNumber * 10 + s.charAt(++i) - '0';
                }
                if (add) {
                    result += currentNumber;
                } else {
                    result -= currentNumber;
                }
            }
        }
        return result;
    }

}
