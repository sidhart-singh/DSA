package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
    private void dfs(String s, List<String> dict, int index, StringBuilder str, List<String> res) {
        if (index == str.length()) {
            res.add(str.substring(0, str.length()));
            return;
        }

        for (int i = 0; i < dict.size(); i++) {
            if (index + dict.get(i).length() <= str.length() &&
                    str.substring(index, index + dict.get(i).length()).equals(dict.get(i))) {
                str.insert(index + dict.get(i).length(), " ");
                dfs(s, dict, index + dict.get(i).length() + 1, str, res);
                str.deleteCharAt(index + dict.get(i).length());
            }
        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        // Collections.sort(wordDict);

        dfs(s, wordDict, 0, str, res);

        System.out.println(res);
        return res
    }
}
