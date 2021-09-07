package dailies.reverseLinkedList;

import commonUtilities.ListNode;

public class ReverseLinkedListApproach1 implements ReverseLinkedList {

    @Override
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode first = head;
        ListNode second = head.next;
        if (second == null) {
            return first;
        }
        head.next = null;
        ListNode third = second.next;
        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        return second;
    }
}
