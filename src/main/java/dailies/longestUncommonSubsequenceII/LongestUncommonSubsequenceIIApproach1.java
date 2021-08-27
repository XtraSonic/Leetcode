package dailies.longestUncommonSubsequenceII;

import java.util.LinkedList;
import java.util.List;

public class LongestUncommonSubsequenceIIApproach1 implements LongestUncommonSubsequenceII {

    @Override
    public int findLUSlength(String... strs) {
        List<PossibleSolution> possibleSolutions = new LinkedList<>();
        for (String currentString : strs) {
            boolean shouldAddNewPossibleSolution = true;
            PossibleSolution possibleSolution = new PossibleSolution(currentString);
            for (PossibleSolution existingPossibleSolution : possibleSolutions) {
                if (existingPossibleSolution.value.length() == currentString.length()) {
                    if (existingPossibleSolution.value.equals(currentString)) {
                        existingPossibleSolution.thereIsOneDuplicate = true;
                        shouldAddNewPossibleSolution = false;
                    }
                } else if (existingPossibleSolution.value.length() > currentString.length()) {
                    if (isIncludedIn(currentString, existingPossibleSolution.value)) {
                        shouldAddNewPossibleSolution = false;
                    }
                }
            }
            if (shouldAddNewPossibleSolution) {

                possibleSolutions.add(possibleSolution);
            }
        }

        return possibleSolutions.stream().filter(PossibleSolution::isValidSolution).map(e -> e.value.length()).reduce(-1, (a, b) -> a > b ? a : b);
    }

    private boolean isIncludedIn(String subString, String longString) {
        int index = 0;
        for (int i = 0; i < longString.length() && index < subString.length(); i++) {
            if (longString.charAt(i) == subString.charAt(index)) {
                index++;
            }
        }
        return index == subString.length();
    }

    static class PossibleSolution {
        String value;
        boolean thereIsOneDuplicate;

        public PossibleSolution(String value) {
            this.value = value;
            thereIsOneDuplicate = false;
        }

        boolean isValidSolution() {
            return !thereIsOneDuplicate;
        }
    }

}
