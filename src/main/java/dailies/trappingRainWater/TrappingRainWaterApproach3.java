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
                    //since height[i] < height[j], it means height[j] == right max and since left max < height[i]
                    // => left max is the min between left and right
                    total += leftMax - height[i];
                }
            } else {
                j--;
                if (rightMax < height[j]) {
                    rightMax = height[j];
                } else {
                    //since height[i] > height[j], it means height[i] == left max and since right max < height[j]
                    // => right max is the min between left and right
                    total += rightMax - height[j];
                }
            }
        }
        return total;
    }
}
