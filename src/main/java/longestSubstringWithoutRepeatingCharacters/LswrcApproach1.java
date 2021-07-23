package longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class LswrcApproach1 implements LongestSubstringWithoutRepeatingCharacters {
    @Override
    public int lengthOfLongestSubstring(String s) {
        int currentIndex = 0;
        int startIndex = 0;
        int max = 0;
        Map<Character, Integer> lastSeenMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (lastSeenMap.containsKey(c)) {
                int lastSeenIndex = lastSeenMap.get(c);
                if (lastSeenIndex >= startIndex) {
                    int currentLength = currentIndex - startIndex;
                    max = Math.max(max, currentLength);
                    startIndex = lastSeenIndex + 1;
                }
            }

            lastSeenMap.put(c, currentIndex);
            currentIndex++;
        }
        int currentLength = currentIndex - startIndex;
        max = Math.max(max, currentLength);

        return max;
    }

}
