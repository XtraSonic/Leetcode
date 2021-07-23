package addTwoNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AddTwoNumbersTest {

    AddTwoNumbers addTwoNumbers;

    @Test
    void test_0_plus_0() {
        evaluateAPlusB(0, 0);
    }

    @Test
    void test_341_plus_465() {
        evaluateAPlusB(341, 465);
    }

    @Test
    void test_465_plus_341() {
        evaluateAPlusB(465, 341);
    }

    @Test
    void test_9999_plus_9999999() {
        evaluateAPlusB(9999, 9999999);
    }

    @Test
    void test_9999999_plus_9999() {
        evaluateAPlusB(9999999, 9999);
    }

    private void evaluateAPlusB(int a, int b) {
        ListNode aListNode = buildListNode(a);
        ListNode bListNode = buildListNode(b);
        assertEquals(a + b, addTwoNumbers.addTwoNumbers(aListNode, bListNode).toInt());
    }

    @Test
    void testBuildingNodes() {
        assertEquals(0, buildListNode(0).toInt());
        assertEquals(10, buildListNode(10).toInt());
        assertEquals(100, buildListNode(100).toInt());
        assertEquals(999, buildListNode(999).toInt());
        assertEquals(9999, buildListNode(9999).toInt());
        assertEquals(1234, buildListNode(1234).toInt());
    }

    private ListNode buildListNode(int number) {

        int digit = number % 10;
        int restOfTheNumber = number / 10;

        if (restOfTheNumber == 0) {
            return new ListNode(digit);
        } else {
            return new ListNode(digit, buildListNode(restOfTheNumber));
        }
    }

}



