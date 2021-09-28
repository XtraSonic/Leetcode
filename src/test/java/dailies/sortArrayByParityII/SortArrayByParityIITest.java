package dailies.sortArrayByParityII;

import org.junit.jupiter.api.Test;
import utilities.TestUtils;

import static java.util.Arrays.asList;

public abstract class SortArrayByParityIITest {
    SortArrayByParityII sortArrayByParityII;

    @Test
    void testExample1() {
        TestUtils.areTheSameOutOfOrder(asList(new int[]{4, 2, 5, 7}), asList(sortArrayByParityII.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    @Test
    void testExample2() {
        TestUtils.areTheSameOutOfOrder(asList(new int[]{2, 3}), asList(sortArrayByParityII.sortArrayByParityII(new int[]{2, 3})));
    }
}
