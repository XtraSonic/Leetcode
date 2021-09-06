package dailies.slowestKey;

public class SlowestKeyApproach1 implements SlowestKey {

    @Override
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        char result = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int currentTime = releaseTimes[i] - releaseTimes[i - 1];
            if (maxTime < currentTime) {
                maxTime = currentTime;
                result = keysPressed.charAt(i);
            } else if (maxTime == currentTime && result < keysPressed.charAt(i)) {
                result = keysPressed.charAt(i);
            }
        }
        return result;
    }
}
