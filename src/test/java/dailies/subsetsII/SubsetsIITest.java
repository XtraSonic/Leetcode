package dailies.subsetsII;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.fail;


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
        compareLists(expected, subsetsII.subsetsWithDup(nums));
    }

    public void compareLists(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (expected.size() != actual.size()) {
            fail("Lists have different sizes: \nexpected=" + expected + "\nactual=" + actual);
        }
        actual.forEach(element -> {
            if (!isIncludedInList(element, expected))
                fail("B contains the element " + element + " which is not present in A: \nexpected=" + expected + "\nactual=" + actual);
        });

        expected.forEach(element -> {
            if (!isIncludedInList(element, actual))
                fail("A contains the element " + element + " which is not present in B: \nexpected=" + expected + "\nactual=" + actual);
        });
    }

    public boolean isIncludedInList(List<Integer> toFind, List<List<Integer>> list) {
        return list.stream().anyMatch(element -> areTheSame(toFind, element));
    }

    public boolean areTheSame(List<Integer> a, List<Integer> b) {
        return a.size() == b.size() && a.containsAll(b) && b.containsAll(a);
    }


}
