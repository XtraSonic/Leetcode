package dailies.trappingRainWater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrappingRainWaterApproach2 implements TrappingRainWater {
    @Override
    public int trap(int[] height) {
        Map<Integer, List<Integer>> peakHeights = new HashMap<>();
        int maxHeight = 0;

        for (int i = 0; i < height.length; i++) {
            if (peakHeights.containsKey(height[i])) {
                peakHeights.get(height[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                peakHeights.put(height[i], list);
            }
            maxHeight = Math.max(maxHeight, height[i]);
        }

        int totalWater = 0;
        int currentHeight = maxHeight;
        int currentNumberOfTallerElements = 0;
        int firstIndex = height.length;
        int lastIndex = 0;
        while (currentHeight > 0) {
            List<Integer> indexes = peakHeights.get(currentHeight);
            if (indexes != null) {
                int numberOfIndexes = indexes.size();
                currentNumberOfTallerElements += numberOfIndexes;
                firstIndex = Math.min(firstIndex, indexes.get(0));
                lastIndex = Math.max(lastIndex, indexes.get(numberOfIndexes - 1));
            }
            //lastIndex - firstIndex + 1 =  number of elements between the indexes including the 2 limits
            totalWater += lastIndex - firstIndex + 1 - currentNumberOfTallerElements;
            currentHeight--;
        }
        return totalWater;
    }

}
