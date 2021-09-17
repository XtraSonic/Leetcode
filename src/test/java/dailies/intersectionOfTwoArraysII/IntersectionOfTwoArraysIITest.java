package dailies.intersectionOfTwoArraysII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class IntersectionOfTwoArraysIITest {
    IntersectionOfTwoArraysII intersectionOfTwoArraysII;

    @Test
    void testExample1() {
        evalIntersect(new int[]{2, 2}, new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    @Test
    void testExample2() {
        int[] expected = {9, 4};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] nums1 = {4, 9, 5};
        evalIntersect(expected, nums2, nums1);
    }

    private void evalIntersect(int[] expected, int[] nums2, int[] nums1) {
        int[] intersect = intersectionOfTwoArraysII.intersect(nums1, nums2);
        Arrays.sort(expected);
        Arrays.sort(intersect);
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(intersect));
        assertArrayEquals(expected, intersect);
    }
}
