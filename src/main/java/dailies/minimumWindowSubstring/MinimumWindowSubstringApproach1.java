package dailies.minimumWindowSubstring;

import java.util.HashMap;

public class MinimumWindowSubstringApproach1 implements MinimumWindowSubstring {

    @Override
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> extraCharsBetweenStartAndFinish = new HashMap<>();
        for (char c : t.toCharArray()) {
            extraCharsBetweenStartAndFinish.put(c, extraCharsBetweenStartAndFinish.getOrDefault(c, 0) - 1);
        }
        int differentCharsToFind = extraCharsBetweenStartAndFinish.size();

        // first find one char of t in s
        int startIndex = 0;
        while (startIndex < s.length() && !extraCharsBetweenStartAndFinish.containsKey(s.charAt(startIndex)))
            startIndex++;

        //find all the chars of t in s starting from the start index
        int finishIndex = startIndex;
        while (finishIndex < s.length() && differentCharsToFind != 0) {
            char currentChar = s.charAt(finishIndex++);
            if (extraCharsBetweenStartAndFinish.containsKey(currentChar)) {
                int newAmountOfExtraChars = extraCharsBetweenStartAndFinish.get(currentChar) + 1;
                extraCharsBetweenStartAndFinish.put(currentChar, newAmountOfExtraChars);
                if (newAmountOfExtraChars == 0) {
                    differentCharsToFind--;
                }
            }
        }

        //if we did not find all the chars of t at this point, we don't have a solution
        if (differentCharsToFind != 0)
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
            if (extraCharsBetweenStartAndFinish.containsKey(currentStartChar)) {
                int extraStartCharactersInTheInterval = extraCharsBetweenStartAndFinish.get(currentStartChar) - 1;
                extraCharsBetweenStartAndFinish.put(currentStartChar, extraStartCharactersInTheInterval);
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
                        if (extraCharsBetweenStartAndFinish.containsKey(currentEndChar)) {
                            extraCharsBetweenStartAndFinish.put(currentEndChar, extraCharsBetweenStartAndFinish.get(currentEndChar) + 1);
                        }

                        finishIndex++;
                    } while (currentStartChar != currentEndChar);
                }

                // now we can eliminate from the start all the chars that are not part of t
                while (startIndex <= maxStartIndex && !extraCharsBetweenStartAndFinish.containsKey(s.charAt(startIndex)))
                    startIndex++;

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
