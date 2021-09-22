package dailies.maximumLengthOfAConcatenatedStringWithUniqueCharacters;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharactersApproach1 implements MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    @Override
    public int maxLength(List<String> arr) {
        return maxLength(new LinkedList<>(arr), new HashSet<>());
    }

    private int maxLength(LinkedList<String> strings, HashSet<Character> usedChars) {
        if (strings.isEmpty())
            return usedChars.size();
        String currentElement = strings.poll();
        int sizeWithoutCurrentElement = maxLength(strings, new HashSet<>(usedChars));
        for (char c : currentElement.toCharArray()) {
            if (usedChars.contains(c)) {
                strings.addFirst(currentElement);
                return sizeWithoutCurrentElement;
            }
            usedChars.add(c);
        }
        int result = Math.max(maxLength(strings, new HashSet<>(usedChars)), sizeWithoutCurrentElement);
        strings.addFirst(currentElement);
        return result;
    }

}
