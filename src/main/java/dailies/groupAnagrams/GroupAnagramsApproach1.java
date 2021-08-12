package dailies.groupAnagrams;

import java.util.*;

public class GroupAnagramsApproach1 implements GroupAnagrams {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> characterFrequencyToStringsMap = new HashMap<>();

        for (String string : strs) {
            int[] frequencyMap = new int[26];
            for (char c : string.toCharArray()) {
                frequencyMap[c - 'a']++;
            }
            int key = Arrays.hashCode(frequencyMap);
            List<String> listOfStrings = characterFrequencyToStringsMap.getOrDefault(key, new ArrayList<>());
            listOfStrings.add(string);
            if (listOfStrings.size() == 1) {
                characterFrequencyToStringsMap.put(key, listOfStrings);
            }
        }

        return new ArrayList<>(characterFrequencyToStringsMap.values());
    }
}
