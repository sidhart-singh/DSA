package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    private void dfs(String s, int index, StringBuilder str, List<String> res) {
        if (index == s.length()) {
            res.add(str.toString());
            return;
        }

        if (Character.isAlphabetic(s.charAt(index))) {
            if (Character.isUpperCase(s.charAt(index))) {
                str.append(Character.toLowerCase(s.charAt(index)));
                dfs(s, index + 1, str, res);
                str.deleteCharAt(str.length() - 1);
            } else if (Character.isLowerCase(s.charAt(index))) {
                str.append(Character.toUpperCase(s.charAt(index)));
                dfs(s, index + 1, str, res);
                str.deleteCharAt(str.length() - 1);
            }
        }
        str.append(s.charAt(index));
        dfs(s, index + 1, str, res);
        str.deleteCharAt(str.length() - 1);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        dfs(s, 0, str, res);

        System.out.println(res);
        return res;
    }
}
