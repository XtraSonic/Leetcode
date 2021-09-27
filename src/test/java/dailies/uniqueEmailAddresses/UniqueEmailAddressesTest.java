package dailies.uniqueEmailAddresses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class UniqueEmailAddressesTest {
    UniqueEmailAddresses uniqueEmailAddresses;

    @Test
    void testExample1() {
        assertEquals(2, uniqueEmailAddresses.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    @Test
    void testExample2() {
        assertEquals(3, uniqueEmailAddresses.numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"}));
    }
}
