import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 *
 * @author Kaitian Xie
 */
class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> visited = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            visited.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return visited.size();
    }
}
