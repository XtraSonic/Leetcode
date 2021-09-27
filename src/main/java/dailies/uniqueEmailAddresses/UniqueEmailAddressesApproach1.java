package dailies.uniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddressesApproach1 implements UniqueEmailAddresses {

    @Override
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            int i = 0;
            StringBuilder currentEmail = new StringBuilder();
            boolean addToEmail = true;
            while (email.charAt(i) != '@') {
                if (addToEmail) {
                    if (email.charAt(i) == '+') {
                        addToEmail = false;
                    } else {
                        if (email.charAt(i) != '.') {
                            currentEmail.append(email.charAt(i));
                        }
                    }
                }
                i++;
            }
            currentEmail.append(email.substring(i));
            uniqueEmails.add(currentEmail.toString());
        }
        return uniqueEmails.size();
    }
}
