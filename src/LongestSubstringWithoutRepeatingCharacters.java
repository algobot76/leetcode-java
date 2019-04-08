import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author Kaitian Xie
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // Sling Window
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int maxLen = 0;
//        int i = 0;
//        int j = 0;
//
//        while (i < s.length() && j < s.length()) {
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                maxLen = Math.max(maxLen, j - i);
//            } else {
//                set.remove(s.charAt(i++));
//            }
//        }
//
//        return maxLen;
//    }

    // Sliding Window (Optimized)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return maxLen;
    }

    // Sliding Window (ASCII)
//    public int lengthOfLongestSubstring(String s) {
//        int maxLen = 0;
//        int i = 0;
//        int[] index = new int[128];
//
//        for (int j = 0; j < s.length(); j++) {
//            i = Math.max(index[s.charAt(j)], i);
//            maxLen = Math.max(maxLen, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//
//        return maxLen;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        if (chars.length < 2) {
//            return chars.length;
//        }
//        int l = 0;
//        int r = 0;
//        int maxLen = 0;
//        while (++l < chars.length) {
//            for (int i = r; i < l; i++) {
//                if (chars[l] == chars[i]) {
//                    if (l - r > maxLen) {
//                        maxLen = l - r;
//                    }
//                    r = i + 1;
//                    break;
//                }
//            }
//        }
//        if (l - r > maxLen) {
//            maxLen = l - r;
//        }
//        return maxLen;
//    }
}
