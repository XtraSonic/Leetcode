package dailies.groupAnagrams;

import java.util.*;

public class GroupAnagramsApproach1 implements GroupAnagrams {

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<CharacterFrequencyCounter, List<String>> characterFrequencyToStringsMap = new HashMap<>();

        for (String string : strs) {
            CharacterFrequencyCounter cfc = new CharacterFrequencyCounter(string);
            List<String> listOfStrings = characterFrequencyToStringsMap.getOrDefault(cfc, new ArrayList<>());
            listOfStrings.add(string);
            if (listOfStrings.size() == 1) {
                characterFrequencyToStringsMap.put(cfc, listOfStrings);
            }
        }

        return new ArrayList<>(characterFrequencyToStringsMap.values());
    }

    static class CharacterFrequencyCounter {
        Map<Character, Integer> frequencyMap;

        public CharacterFrequencyCounter(String s) {
            frequencyMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                int currentFrequency = frequencyMap.getOrDefault(c, 0);
                frequencyMap.put(c, currentFrequency + 1);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharacterFrequencyCounter that = (CharacterFrequencyCounter) o;
            return Objects.equals(frequencyMap, that.frequencyMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(frequencyMap);
        }
    }
}
