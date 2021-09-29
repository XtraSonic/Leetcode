package dailies.splitLinkedListInParts;

import commonUtilities.ListNode;

public class SplitLinkedListInPartsApproach1 implements SplitLinkedListInParts {

    @Override
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode currentElement = head;
        while (currentElement != null) {
            currentElement = currentElement.next;
            count++;
        }
        int minInEachGroup = count / k;
        int groupsWithExtraElements = count % k;


        ListNode[] result = new ListNode[k];
        currentElement = head;
        for (int i = 0; i < k; i++) {
            result[i] = currentElement;
            for (int j = 0; currentElement != null && j + 1 < minInEachGroup; j++) {
                currentElement = currentElement.next;
            }
            if (currentElement != null && i < groupsWithExtraElements && minInEachGroup > 0) {
                currentElement = currentElement.next;
            }
            if (currentElement != null) {
                ListNode previousElement = currentElement;
                currentElement = currentElement.next;
                previousElement.next = null;
            }
        }

        return result;
    }
}
