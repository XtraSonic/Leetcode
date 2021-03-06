package dailies.reverseOnlyLetters;

public class ReverseOnlyLettersApproach1 implements ReverseOnlyLetters {

    @Override
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left])) left++;
            while (left < right && !Character.isLetter(chars[right])) right--;
            if (left < right) {
                char aux = chars[left];
                chars[left] = chars[right];
                chars[right] = aux;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
