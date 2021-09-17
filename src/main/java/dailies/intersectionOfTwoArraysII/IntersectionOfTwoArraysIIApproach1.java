package dailies.intersectionOfTwoArraysII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArraysIIApproach1 implements IntersectionOfTwoArraysII {

    @Override
    public int[] intersect(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? intersect2(nums1, nums2) : intersect2(nums2, nums1);
    }

    private int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> result = new LinkedList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int j : nums1) {
            frequencyMap.put(j, frequencyMap.getOrDefault(j, 0) + 1);
        }
        for (int i = 0; i < nums2.length && !frequencyMap.isEmpty(); i++) {
            if (frequencyMap.containsKey(nums2[i])) {
                Integer val = frequencyMap.get(nums2[i]);
                if (val == 1) {
                    frequencyMap.remove(nums2[i]);
                } else {
                    frequencyMap.put(nums2[i], val - 1);
                }
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }
}
