package dailies.intersectionOfTwoArraysII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArraysIIApproach2 implements IntersectionOfTwoArraysII {
    @Override
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        List<Integer> res = new LinkedList<>();
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                res.add(nums1[i1]);
                i1++;
                i2++;
            } else {
                if (nums1[i1] > nums2[i2]) {
                    i2++;
                } else {
                    i1++;
                }
            }
        }

        return res.stream().mapToInt(e -> e).toArray();
    }
}
