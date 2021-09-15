package dailies.longestTurbulentSubarray;

public class LongestTurbulentSubarrayApproach1 implements LongestTurbulentSubarray {

    @Override
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 0)
            return 0;
        int previousDif = 0;
        int result = 1;
        int currentSize = 1;
        for (int i = 1; i < arr.length; i++) {
            int currentDif = arr[i] - arr[i - 1];
            if ((currentDif > 0 && previousDif <= 0) || (currentDif < 0 && previousDif >= 0)) {
                currentSize++;
            } else {
                result = Math.max(result, currentSize);
                currentSize = currentDif == 0 ? 1 : 2;
            }
            previousDif = currentDif;
        }
        return Math.max(result, currentSize);
    }
}
