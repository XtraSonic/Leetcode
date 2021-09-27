package dailies.uniqueEmailAddresses;

import org.junit.jupiter.api.BeforeEach;

public class UniqueEmailAddressesApproach1Test extends UniqueEmailAddressesTest {
    @BeforeEach
    void setup() {
        uniqueEmailAddresses = new UniqueEmailAddressesApproach1();
    }
}
