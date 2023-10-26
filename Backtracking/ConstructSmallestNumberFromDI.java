package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class ConstructSmallestNumberFromDI {
    // Backtracking Solution
    private void dfs(String pattern, int index, Set<Integer> digits, StringBuilder s) {
        if (index == pattern.length() + 1) {
            System.out.println(s);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (digits.contains(i))
                continue;

            if (pattern.charAt(index - 1) == 'I'
                    && i > Character.getNumericValue(s.charAt(index - 1))) {
                s.append(i);
                digits.add(i);
                dfs(pattern, index + 1, digits, s);
                if (s.length() == pattern.length() + 1)
                    return;
                digits.remove(i);
                s.deleteCharAt(s.length() - 1);
            } else if (pattern.charAt(index - 1) == 'D'
                    && i < Character.getNumericValue(s.charAt(index - 1))) {
                s.append(i);
                digits.add(i);
                dfs(pattern, index + 1, digits, s);
                if (s.length() == pattern.length() + 1)
                    return;
                digits.remove(i);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public String smallestNumber(String pattern) {
        // Backtracking Solution:
        // StringBuilder s = new StringBuilder();
        // Set<Integer> used = new HashSet<>();

        // for (int i = 1; i < 10; i++) {
        // s.append(i);
        // used.add(i);
        // if ((pattern.charAt(0) == 'I' && i > Character.getNumericValue(s.charAt(0)))
        // || (pattern.charAt(0) == 'D' && i < Character.getNumericValue(s.charAt(0))))
        // break;
        // dfs(pattern, 1, used, s);
        // if (s.length() == pattern.length() + 1)
        // break;
        // used.remove(i);
        // s.deleteCharAt(0);
        // }
        // return s.toString();

        // Optimal Solution
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char) ('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}
