package dailies.reverseLinkedList;

import commonUtilities.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class ReverseLinkedListTest {
    ReverseLinkedList reverseLinkedList;

    @Test
    void testExample1() {
        evaluateReverseLinkedList(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void testExample2() {
        evaluateReverseLinkedList(new int[]{2, 1}, new int[]{1, 2});
    }

    @Test
    void testOneElement() {
        evaluateReverseLinkedList(new int[]{1}, new int[]{1});
    }

    private void evaluateReverseLinkedList(int[] expected, int[] input) {
        assertArrayEquals(expected, reverseLinkedList.reverseList(ListNode.fromArray(input)).toArray());
    }
}
