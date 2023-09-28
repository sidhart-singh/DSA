package Recursion;

import java.util.List;

public class WordBreak {
    private boolean dfs(String s, List<String> dict, int index, Boolean[] dp) {
        if (index == s.length())
            return true;
        if (dp[index] != null)
            return dp[index];

        // iterating through the dict : so 'i' is not used for recursive calls
        for (int i = 0; i < dict.size(); i++) {
            if (index + dict.get(i).length() <= s.length() &&
                    s.substring(index, index + dict.get(i).length()).equals(dict.get(i))) {
                if (dfs(s, dict, index + dict.get(i).length(), dp))
                    return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dfs(s, wordDict, 0, dp);
    }
}
