package dailies.subsetsII;

import java.util.*;

public class SubsetsIIApproach1 implements SubsetsII {

    @Override
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        result.add(Collections.emptyList());
        for (int num : nums) {
            Set<List<Integer>> tempResult = new HashSet<>(result);
            for (List<Integer> list : tempResult) {
                List<Integer> intermediarySet = new ArrayList<>(list);
                intermediarySet.add(num);
                result.add(intermediarySet);
            }
        }

        return new ArrayList<>(result);
    }

}
