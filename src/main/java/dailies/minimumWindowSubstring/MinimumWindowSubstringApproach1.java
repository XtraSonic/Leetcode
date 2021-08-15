package dailies.minimumWindowSubstring;

import java.util.HashMap;

public class MinimumWindowSubstringApproach1 implements MinimumWindowSubstring {

    @Override
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charsToFind = new HashMap<>();
        HashMap<Character, Integer> charsFound = new HashMap<>();
        for (char c : t.toCharArray()) {
            charsToFind.put(c, charsToFind.getOrDefault(c, 0) + 1);
            charsFound.put(c, charsFound.getOrDefault(c, 0) - 1);
        }

        //find one char fist
        int startIndex = 0;
        while (startIndex < s.length() && !charsToFind.containsKey(s.charAt(startIndex))) startIndex++;

        //find all the chars of t in s starting from the start index
        int finishIndex = startIndex;
        while (finishIndex < s.length() && !charsToFind.isEmpty()) {
            char currentChar = s.charAt(finishIndex++);
            if (charsToFind.containsKey(currentChar)) {
                charsFound.put(currentChar, charsFound.getOrDefault(currentChar, 0) + 1);
                int numberOfCharactersLeftToFind = charsToFind.get(currentChar) - 1;
                if (numberOfCharactersLeftToFind == 0) {
                    charsToFind.remove(currentChar);
                } else {
                    charsToFind.put(currentChar, numberOfCharactersLeftToFind);
                }
            } else {
                if (charsFound.containsKey(currentChar)) {
                    charsFound.put(currentChar, charsFound.get(currentChar) + 1);
                }
            }
        }

        //if we did not find all the chars of t at this point, we don't have a solution
        if (!charsToFind.isEmpty())
            return "";

        //otherwise, we have our first possible solution
        int solutionStartIndex = startIndex;
        int solutionFinishIndex = finishIndex;
        int minDiff = finishIndex - startIndex;

        //now we assume the starting index is not the one we chose
        int maxStartIndex = s.length() - t.length();
        while (startIndex <= maxStartIndex) {
            char currentStartChar = s.charAt(startIndex);
            startIndex++;
            if (charsFound.containsKey(currentStartChar)) {
                int extraStartCharactersInTheInterval = charsFound.get(currentStartChar) - 1;
                charsFound.put(currentStartChar, extraStartCharactersInTheInterval);
                if (extraStartCharactersInTheInterval < 0) {
                    // if we do not have the start character in our current interval,
                    // we need to find it by incrementing the end
                    char currentEndChar;
                    do {
                        if (finishIndex >= s.length()) {
                            //we did not find the missing starting char so there are no other solutions
                            return s.substring(solutionStartIndex, solutionFinishIndex);
                        }
                        currentEndChar = s.charAt(finishIndex);

                        //since the interval is growing, we need to add relevant characters to the solution
                        if (charsFound.containsKey(currentEndChar)) {
                            charsFound.put(currentEndChar, charsFound.get(currentEndChar) + 1);
                        }

                        finishIndex++;
                    } while (currentStartChar != currentEndChar);
                }

                // now we can eliminate from the start all the chars that are not part of t
                while (startIndex <= maxStartIndex && !charsFound.containsKey(s.charAt(startIndex))) startIndex++;

                if (startIndex > maxStartIndex) {
                    //we cannot have another solution
                    return s.substring(solutionStartIndex, solutionFinishIndex);
                } else {
                    // we have another possible solution
                    int currentDiff = finishIndex - startIndex;
                    if (minDiff > currentDiff) {
                        minDiff = currentDiff;
                        solutionStartIndex = startIndex;
                        solutionFinishIndex = finishIndex;
                    }
                }

            }
        }


        return s.substring(solutionStartIndex, solutionFinishIndex);
    }
}
