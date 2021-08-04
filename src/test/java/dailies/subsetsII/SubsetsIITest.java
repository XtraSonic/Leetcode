package dailies.subsetsII;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static utilities.TestUtils.compareListsOutOfOrder;


public abstract class SubsetsIITest {
    SubsetsII subsetsII;

    @Test
    void testExample1() {
        evaluateSubsetsII(asList(
                asList(),
                asList(1),
                asList(1, 2),
                asList(1, 2, 2),
                asList(2),
                asList(2, 2)
        ), new int[]{1, 2, 2});
    }

    @Test
    void testExample2() {
        evaluateSubsetsII(asList(
                asList(),
                asList(0)
        ), new int[]{0});
    }

    @Test
    void testAllUniqueNumbers() {
        evaluateSubsetsII(asList(
                asList(),
                asList(1),
                asList(2),
                asList(3),
                asList(1, 2),
                asList(1, 3),
                asList(2, 3),
                asList(1, 2, 3)
        ), new int[]{1, 2, 3});
    }

    @Test
    void testOutOfOrderAndUnique() {

        evaluateSubsetsII(asList(
                asList(),
                asList(1),
                asList(2),
                asList(3),
                asList(1, 2),
                asList(1, 3),
                asList(2, 3),
                asList(1, 2, 3)
        ), new int[]{3, 1, 2});
    }


    @Test
    void testOutOfOrder() {
        evaluateSubsetsII(asList(
                asList(),
                asList(1),
                asList(1, 2),
                asList(1, 2, 2),
                asList(2),
                asList(2, 2)
        ), new int[]{2, 1, 2});
    }

    private void evaluateSubsetsII(List<List<Integer>> expected, int[] nums) {
        compareListsOutOfOrder(expected, subsetsII.subsetsWithDup(nums));
    }
}
