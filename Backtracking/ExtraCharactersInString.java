package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCharactersInString {
    private int dfs(String s, Set<String> set, int index, Map<Integer, Integer> dp) {
        if (index == s.length())
            return 0;
        if (dp.containsKey(index))
            return dp.get(index);

        int res = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1)))
                res = Math.min(res, dfs(s, set, i + 1, dp));
            else
                // i - index + 1
                res = Math.min(res, i - index + 1 + dfs(s, set, i + 1, dp));
        }
        dp.put(index, res);

        return res;
    }

    public int minExtraChar(String s, String[] dict) {
        Map<Integer, Integer> dp = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String str : dict)
            set.add(str);

        return dfs(s, set, 0, dp);
    }
}
