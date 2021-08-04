package utilities;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class TestUtils {

    public static void compareListsOutOfOrder(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (expected.size() != actual.size()) {
            fail("Lists have different sizes: \nexpected=" + expected + "\nactual=" + actual);
        }
        actual.forEach(element -> {
            if (!isIncludedInListOutOfOrder(element, expected))
                fail("B contains the element " + element + " which is not present in A: \nexpected=" + expected + "\nactual=" + actual);
        });

        expected.forEach(element -> {
            if (!isIncludedInListOutOfOrder(element, actual))
                fail("A contains the element " + element + " which is not present in B: \nexpected=" + expected + "\nactual=" + actual);
        });
    }

    public static boolean isIncludedInListInOrder(List<Integer> toFind, List<List<Integer>> list) {
        return list.stream().anyMatch(toFind::equals);
    }

    public static boolean isIncludedInListOutOfOrder(List<Integer> toFind, List<List<Integer>> list) {
        return list.stream().anyMatch(element -> areTheSameOutOfOrder(toFind, element));
    }

    public static boolean areTheSameOutOfOrder(List<Integer> a, List<Integer> b) {
        return a.size() == b.size() && a.containsAll(b) && b.containsAll(a);
    }

    public static void compareListsWithInOrderElements(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (expected.size() != actual.size()) {
            fail("Lists have different sizes: \nexpected=" + expected + "\nactual=" + actual);
        }
        actual.forEach(element -> {
            if (!isIncludedInListInOrder(element, expected))
                fail("B contains the element " + element + " which is not present in A: \nexpected=" + expected + "\nactual=" + actual);
        });

        expected.forEach(element -> {
            if (!isIncludedInListInOrder(element, actual))
                fail("A contains the element " + element + " which is not present in B: \nexpected=" + expected + "\nactual=" + actual);
        });
    }

}
