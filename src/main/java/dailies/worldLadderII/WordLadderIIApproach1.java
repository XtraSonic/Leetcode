package dailies.worldLadderII;

import java.util.*;

public class WordLadderIIApproach1 implements WordLadderII {
    @Override
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> neighboursMap = new HashMap<>();
        neighboursMap.put(beginWord, new HashSet<>());
        Set<String> seenWords = new HashSet<>();
        seenWords.add(beginWord);
        for (String word : wordList) {
            for (String seenWord : seenWords) {
                if (differByOne(word, seenWord)) {
                    addNeighbour(neighboursMap, seenWord, word);
                    addNeighbour(neighboursMap, word, seenWord);
                }
            }
            seenWords.add(word);
        }
        List<List<String>> results = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        Map<String, Integer> visitedNodes = new HashMap<>();
        List<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        queue.add(startPath);
        while (!queue.isEmpty()) {
            List<String> currentPath = queue.poll();
            String currentWord = currentPath.get(currentPath.size() - 1);
            Set<String> neighbours = neighboursMap.get(currentWord);
            if (neighbours == null) {
                continue;
            }
            if (visitedNodes.containsKey(currentWord)) {
                if (visitedNodes.get(currentWord) < currentPath.size()) {
                    continue;
                }
            } else {
                visitedNodes.put(currentWord, currentPath.size());
            }
            for (String neighbour : neighbours) {
                if (neighbour.equals(endWord)) {
                    currentPath.add(endWord);
                    if (!results.isEmpty() && results.get(0).size() < currentPath.size()) {
                        return results;
                    }
                    results.add(currentPath);
                } else if (!currentPath.contains(neighbour)) {
                    List<String> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbour);
                    queue.add(newPath);
                }
            }
        }
        return results;
    }


    private void addNeighbour(Map<String, Set<String>> neighboursMap, String word, String seenWord) {
        Set<String> neighboursOfSeenWord = neighboursMap.get(seenWord);
        if (neighboursOfSeenWord == null) {
            neighboursOfSeenWord = new HashSet<>();
            neighboursOfSeenWord.add(word);
            neighboursMap.put(seenWord, neighboursOfSeenWord);
        } else {
            neighboursOfSeenWord.add(word);
        }
    }

    private boolean differByOne(String aString, String bString) {
        // both strings have the same length
        char[] a = aString.toCharArray();
        char[] b = bString.toCharArray();
        boolean diffByOne = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (diffByOne) {
                    return false;
                } else {
                    diffByOne = true;
                }
            }
        }
        return diffByOne;
    }

}
