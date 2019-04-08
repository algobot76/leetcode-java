/**
 * 5. Longest Palindromic Substring
 *
 * @author Kaitian Xie
 */
public class LongestPalindromicSubstring {
    // Expand Around Center
//    public String longestPalindrome(String s) {
//        if (s == null) {
//            return null;
//        }
//        if (s.isEmpty()) {
//            return "";
//        }
//
//        int start = 0;
//        int end = 0;
//        int maxLen = 1;
//
//        for (int i = 0; i < s.length(); i++) {
//            int left = i;
//            int right = i;
//            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//            if (maxLen < right - left + 1) {
//                maxLen = right - left + 1;
//                start = left + 1;
//                end = right - 1;
//            }
//            left = i;
//            right = i + 1;
//            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//            if (maxLen < right - left + 1) {
//                maxLen = right - left + 1;
//                start = left + 1;
//                end = right - 1;
//            }
//        }
//
//        return s.substring(start, end + 1);
//    }

    // Dynamic Programming
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}
