package dailies.sortArrayByParityII;

public class SortArrayByParityIIApproach1 implements SortArrayByParityII {

    @Override
    public int[] sortArrayByParityII(int[] nums) {
        int oddOutOfOrder = 1;
        int evenOutOfOrder = 0;

        while (oddOutOfOrder < nums.length) {// if oddOutOfOrder<nums.length then it is guaranteed that so is evenOutOfOrder
            while (oddOutOfOrder < nums.length && nums[oddOutOfOrder] % 2 == 1) oddOutOfOrder += 2;
            while (evenOutOfOrder < nums.length && nums[evenOutOfOrder] % 2 == 0) evenOutOfOrder += 2;
            if (oddOutOfOrder < nums.length) {
                // if oddOutOfOrder<nums.length then it is guaranteed that so is evenOutOfOrder
                int aux = nums[evenOutOfOrder];
                nums[evenOutOfOrder] = nums[oddOutOfOrder];
                nums[oddOutOfOrder] = aux;
                evenOutOfOrder += 2;
                oddOutOfOrder += 2;
            }
        }
        return nums;
    }
}
