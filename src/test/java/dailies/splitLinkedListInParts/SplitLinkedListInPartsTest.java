package dailies.splitLinkedListInParts;

import commonUtilities.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SplitLinkedListInPartsTest {
    SplitLinkedListInParts splitLinkedListInParts;

    @Test
    void testExample1() {
        ListNode[] expected = {
                ListNode.fromArray(1),
                ListNode.fromArray(2),
                ListNode.fromArray(3),
                null,
                null,
        };
        eval(expected, ListNode.fromArray(1, 2, 3), 5);
    }


    @Test
    void testExample2() {
        ListNode[] expected = {
                ListNode.fromArray(1, 2, 3, 4),
                ListNode.fromArray(5, 6, 7),
                ListNode.fromArray(8, 9, 10)
        };
        int k = 3;
        ListNode head = ListNode.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        eval(expected, head, k);
    }

    private void eval(ListNode[] expected, ListNode head, int k) {
        ListNode[] actual = splitLinkedListInParts.splitListToParts(head, k);
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        System.out.println();

        assertArrayEquals(expected, actual);
    }
}
