package commonUtilities;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode fromArray(int... numbers) {
        ListNode root = new ListNode(numbers[0]);
        ListNode previous = root;
        ListNode current;
        for (int i = 1; i < numbers.length; i++) {
            current = new ListNode(numbers[i]);
            previous.next = current;
            previous = current;
        }
        return root;
    }

    public int toInt() {
        if (next == null) {
            return val;
        } else {
            return 10 * next.toInt() + val;
        }
    }

    public int[] toArray() {
        List<Integer> aux = new LinkedList<>();
        ListNode current = this;
        while (current != null) {
            aux.add(current.val);
            current = current.next;
        }
        return aux.stream().mapToInt(e -> e).toArray();
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
