package utilities;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class TestUtils {

    public static <T> void compareListsOutOfOrder(List<List<T>> expected, List<List<T>> actual) {
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

    public static <T> boolean isIncludedInListInOrder(List<T> toFind, List<List<T>> list) {
        return list.stream().anyMatch(toFind::equals);
    }

    public static <T> boolean isIncludedInListOutOfOrder(List<T> toFind, List<List<T>> list) {
        return list.stream().anyMatch(element -> areTheSameOutOfOrder(toFind, element));
    }

    public static <T> boolean areTheSameOutOfOrder(List<T> a, List<T> b) {
        return a.size() == b.size() && a.containsAll(b) && b.containsAll(a);
    }

    public static <T> void compareListsWithInOrderElements(List<List<T>> expected, List<List<T>> actual) {
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
