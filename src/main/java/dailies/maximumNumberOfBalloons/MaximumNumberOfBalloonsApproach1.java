package dailies.maximumNumberOfBalloons;

public class MaximumNumberOfBalloonsApproach1 implements MaximumNumberOfBalloons {

    @Override
    public int maxNumberOfBalloons(String text) {
        String balloonChars = "balon";
        int[] frequency = new int[balloonChars.length()];
        for (int i = 0; i < text.length(); i++) {
            int index = balloonChars.indexOf(text.charAt(i));
            if (index >= 0) {
                frequency[index]++;
            }
        }
        int min = frequency[0];
        for (int i = 1; i < frequency.length; i++) {
            int currentValue = i == balloonChars.indexOf('l') || i == balloonChars.indexOf('o') ? frequency[i] / 2 : frequency[i];
            if (min > currentValue) {
                min = currentValue;
            }

        }
        return min;
    }
}
