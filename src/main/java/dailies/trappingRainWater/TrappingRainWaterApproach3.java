package dailies.trappingRainWater;

public class TrappingRainWaterApproach3 implements TrappingRainWater {
    @Override
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int total = 0;
        int i = 0;
        int j = height.length - 1;
        int leftMax = height[i];
        int rightMax = height[j];
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
                if (leftMax < height[i]) {
                    leftMax = height[i];
                } else {
                    total += Math.min(leftMax, rightMax) - height[i];
                }
            } else {
                j--;
                if (rightMax < height[j]) {
                    rightMax = height[j];
                } else {
                    total += Math.min(leftMax, rightMax) - height[j];
                }
            }
        }
        return total;
    }
}
