package addTwoNumbers;

public class AddTwoNumbersApproach1 implements AddTwoNumbers {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        int currentValue = l1.val + l2.val + carry;
        int newCarry = currentValue / 10;
        int currentDigit = currentValue % 10;
        if (l1.next != null && l2.next != null) {
            return new ListNode(currentDigit, addTwoNumbers(l1.next, l2.next, newCarry));
        }
        if (l1.next != null) {
            return new ListNode(currentDigit, addTwoNumbers(l1.next, newCarry));
        }
        return getTrailingListNode(l2, newCarry, currentDigit);
    }

    public ListNode addTwoNumbers(ListNode l, int carry) {
        if (carry == 0)
            return l;
        int currentValue = l.val + carry;
        int newCarry = currentValue / 10;
        int currentDigit = currentValue % 10;
        return getTrailingListNode(l, newCarry, currentDigit);
    }

    private ListNode getTrailingListNode(ListNode l, int newCarry, int currentDigit) {
        if (l.next != null) {
            return new ListNode(currentDigit, addTwoNumbers(l.next, newCarry));
        }
        if (newCarry == 0) {
            return new ListNode(currentDigit);
        } else {
            ListNode carryListNode = new ListNode(newCarry);
            return new ListNode(currentDigit, carryListNode);
        }
    }
}
