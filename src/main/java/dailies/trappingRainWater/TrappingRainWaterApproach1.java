package dailies.trappingRainWater;

public class TrappingRainWaterApproach1 implements TrappingRainWater {

    @Override
    public int trap(int[] height) {
        int total = 0;
        boolean startAccumulating = true;
        while (startAccumulating) {
            startAccumulating = false;
            int currentWaterLevel = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0) {
                    if (startAccumulating) {
                        total += currentWaterLevel;
                        currentWaterLevel = 0;
                    }
                    startAccumulating = true;
                    height[i]--;
                } else {
                    if (startAccumulating) {
                        currentWaterLevel++;
                    }
                }
            }
        }
        return total;
    }
}
