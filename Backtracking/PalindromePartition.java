package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    private boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;

        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end))
                return false;
        }

        return true;
    }

    private void dfs(String s, int index, List<List<String>> result, List<String> subList) {
        if (index == s.length()) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // Node
            if (isPalindrome(s.substring(index, i + 1))) {
                // change
                subList.add(s.substring(index, i + 1));
                // children
                dfs(s, i + 1, result, subList);
                // undo change
                subList.remove(subList.size() - 1);
            }

        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> subList = new ArrayList<>();
        dfs(s, 0, result, subList);
        // System.out.println(result);
        return result;
    }
}
