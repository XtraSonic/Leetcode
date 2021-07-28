package dailies.beautifulArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BeautifulArrayApproach2 implements BeautifulArray {     //incomplete

    @Override
    public int[] beautifulArray(int n) {

        // this solution is incomplete

        int[] result = new int[n];
        result[0] = 1;
        Aux a = new Aux(2, result, n);
        a.insert(1, n);
        return result;
    }

    private static class Aux {
        int current;
        int[] nums;
        int n;

        public Aux(int current, int[] nums, int n) {
            this.current = current;
            this.nums = nums;
            this.n = n;
        }

        private void insert(int low, int high) {
            Queue<List<Integer>> indexes = new LinkedList<>();
            indexes.add(Arrays.asList(low, high));
            while (current <= n) {
                List<Integer> pair = indexes.poll();
                int newLow = pair.get(0);
                int newHigh = pair.get(1);
                int newIndex = (newLow + newHigh + 1) / 2 - 1;
                nums[newIndex] = current;
                current++;
                indexes.add(Arrays.asList(newLow, newIndex));
                indexes.add(Arrays.asList(newIndex + 1, newHigh));
            }
        }

        public int[] getNums() {
            return nums;
        }
    }
}
