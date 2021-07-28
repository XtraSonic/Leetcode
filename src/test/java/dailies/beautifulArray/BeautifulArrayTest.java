package dailies.beautifulArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class BeautifulArrayTest {
    BeautifulArray beautifulArray;

//    @Test
//    void test1() {
//        int[] result = beautifulArray.beautifulArray(1);
//        simpleValidator(result);
//    }
//
//
//    @Test
//    void test2() {
//        int[] result = beautifulArray.beautifulArray(2);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test3() {
//        int[] result = beautifulArray.beautifulArray(3);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test4() {
//        int[] result = beautifulArray.beautifulArray(4);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test5() {
//        int[] result = beautifulArray.beautifulArray(5);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test10() {
//        int[] result = beautifulArray.beautifulArray(10);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test20() {
//        int[] result = beautifulArray.beautifulArray(20);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test30() {
//        int[] result = beautifulArray.beautifulArray(30);
//        simpleValidator(result);
//    }
//
//    @Test
//    void test40() {
//        int[] result = beautifulArray.beautifulArray(40);
//        simpleValidator(result);
//    }

    @Test
    void testAllTo64() {
        for (int i = 0; i < 65; i++) {
            simpleValidator(beautifulArray.beautifulArray(i));
        }
    }


    void simpleValidator(int[] nums) {
        boolean[] valuesInArray = new boolean[nums.length + 1];
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (valuesInArray[nums[i]]) {
                fail("The int " + (nums[i] + 1) + " was put twice in the array:" + Arrays.toString(nums));
            }
            valuesInArray[nums[i]] = true;
            for (int j = i + 2; j < nums.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (2 * nums[k] == nums[i] + nums[j]) {
                        fail("Fail at ikj=" + i + ";" + k + ";" + j + "; Vals=" + nums[i] + ";" + nums[k] + ";" + nums[j] + "; nums:" + Arrays.toString(nums)
                        );
                    }
                }
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!valuesInArray[i])
                fail("The int " + i + " was never inserted in the array:" + Arrays.toString(nums));
        }
    }
}
