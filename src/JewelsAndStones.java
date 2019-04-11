import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 *
 * @author Kaitian Xie
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        for (char j : J.toCharArray()) {
            jSet.add(j);
        }

        int count = 0;
        for (char s : S.toCharArray()) {
            if (jSet.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
