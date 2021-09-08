package dailies.shiftingLetters;

public class ShiftingLettersApproach1 implements ShiftingLetters {

    @Override
    public String shiftingLetters(String s, int[] shifts) {
        char[] newChars = new char[s.length()];
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum = (shifts[i] + sum) % 26;
            newChars[i] = (char) ((s.charAt(i) - 'a' + sum) % 26 + 'a');
        }
        return String.valueOf(newChars);
    }
}
