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

    @Test
    void testLargeArrayOfZeros() {
        int[] array = new int[100000];
        evalIntersect(array, array, array);
    }

    @Test
    void testLargeArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 1, 3412, 46, 3751, 463, 15, 123, 46, 21346, 23, 465, 236, 1, 2345, 1, 347, 1537, 8264, 84, 5382, 4357, 24, 57, 12346, 15, 7, 35798, 345, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678, 7, 2357, 246, 872, 457, 2, 457, 234, 6, 32, 569, 3, 79, 9, 56, 982, 649, 357, 1, 123, 56, 2, 5436, 2, 3456, 5, 47, 267, 2, 36, 1, 4, 245, 7, 68, 2, 35, 72, 68, 53678};
        evalIntersect(array, array, array);
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
