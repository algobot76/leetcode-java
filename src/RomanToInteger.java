import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class RomanToInteger {
    // Hash Table
//    public static int romanToInt(String s) {
//        if (s == null || s.isEmpty()) {
//            return -1;
//        }
//
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//
//        int len = s.length();
//        int result = map.get(s.charAt(len - 1));
//        for (int i = len - 2; i >= 0; i--) {
//            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
//                result += map.get(s.charAt(i));
//            else
//                result -= map.get(s.charAt(i));
//        }
//
//        return result;
//    }

    public int romanToInt(String s) {
        int index = 0;
        int ans = 0;

        while (index < s.length()) {
            switch (s.charAt(index)) {
                case 'I':
                    if (index < s.length() - 1 && s.charAt(index + 1) == 'V') {
                        ans += 4;
                        index += 1;
                    } else if (index < s.length() - 1 && s.charAt(index + 1) == 'X') {
                        ans += 9;
                        index += 1;
                    } else
                        ans += 1;
                    break;
                case 'X':
                    if (index < s.length() - 1 && s.charAt(index + 1) == 'L') {
                        ans += 40;
                        index += 1;
                    } else if (index < s.length() - 1 && s.charAt(index + 1) == 'C') {
                        ans += 90;
                        index += 1;
                    } else
                        ans += 10;
                    break;
                case 'C':
                    if (index < s.length() - 1 && s.charAt(index + 1) == 'D') {
                        ans += 400;
                        index += 1;
                    } else if (index < s.length() - 1 && s.charAt(index + 1) == 'M') {
                        ans += 900;
                        index += 1;
                    } else
                        ans += 100;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
            index += 1;
        }

        return ans;
    }
}
