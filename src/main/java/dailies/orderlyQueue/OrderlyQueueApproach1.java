package dailies.orderlyQueue;

import java.util.Arrays;

public class OrderlyQueueApproach1 implements OrderlyQueue {

    @Override
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        } else {
            String minString = s;
            char[] string = s.toCharArray();
            for (int i = 1; i < s.length(); i++) {
                String newString = String.valueOf(string, 1, s.length() - 1) + string[0];
                string = newString.toCharArray();
                if (newString.compareTo(minString) < 0) {
                    minString = newString;
                }
            }
            return minString;
        }
    }
}
