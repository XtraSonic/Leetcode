package dailies.groupAnagrams;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static utilities.TestUtils.compareListsOutOfOrder;

public abstract class GroupAnagramsTest {
    GroupAnagrams groupAnagrams;

    @Test
    void testExample1() {
        compareListsOutOfOrder(asList(
                asList("bat"),
                asList("nat", "tan"),
                asList("ate", "eat", "tea")
        ), groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    @Test
    void testExample2() {

        compareListsOutOfOrder(asList(
                asList("")
        ), groupAnagrams.groupAnagrams(new String[]{""}));
    }

    @Test
    void testExample3() {
        compareListsOutOfOrder(asList(
                asList("a")
        ), groupAnagrams.groupAnagrams(new String[]{"a"}));
    }
}
