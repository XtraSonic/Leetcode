package addTwoNumbers;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int toInt() {
        if (next == null) {
            return val;
        } else {
            return 10 * next.toInt() + val;
        }
    }
}
