import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. Valid Parentheses
 *
 * @author Kaitian Xie
 */
public class ValidParentheses {
    // Stack
//    public boolean isValid(String s) {
//        Map<Character, Character> mapppings = new HashMap<>();
//        mapppings.put(')', '(');
//        mapppings.put('}', '{');
//        mapppings.put(']', '[');
//        Deque<Character> stack = new ArrayDeque<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (mapppings.containsKey(ch)) {
//                char top = stack.isEmpty() ? '#' : stack.pop();
//                if (top != mapppings.get(ch)) {
//                    return false;
//                }
//            } else {
//                stack.push(ch);
//            }
//        }
//
//        return stack.isEmpty();
//    }

    // Stack (Optimized)
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int ptr = 0;
        char[] map = new char[s.length()];

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    map[ptr++] = ch;
                    break;
                case ')':
                    if (ptr == 0 || map[--ptr] != '(')
                        return false;
                    break;
                case '}':
                    if (ptr == 0 || map[--ptr] != '{')
                        return false;
                    break;
                case ']':
                    if (ptr == 0 || map[--ptr] != '[')
                        return false;
                    break;
            }
        }

        return ptr == 0;
    }
}
