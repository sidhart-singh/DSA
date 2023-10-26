package Backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {

    private int dfs(String[] words, StringBuilder sword, Map<Integer, Set<String>> map,
            Map<String, Integer> dp) {
        String word = sword.toString();
        if (!map.containsKey(word.length() - 1)) {
            return 1;
        }
        if (dp.containsKey(word)) {
            return dp.get(word);
        }
        int res = 1;
        Set<String> set = map.get(word.length() - 1);
        for (int i = 0; i < word.length(); i++) {
            String word2 = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(word2)) {
                res = Math.max(res, 1 + dfs(words, new StringBuilder(word2), map, dp));
            }
        }
        dp.put(word, res);
        return res;
    }

    public int longestStrChain(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();
        Map<String, Integer> dp = new HashMap<>();

        /*
         * If the length is already a key, it retrieves the existing HashSet associated
         * with that length and adds the word to it.
         * If the length is not already a key, it creates a new HashSet, associates it
         * with the length, and adds the word to it.
         */
        for (String word : words) {
            map.computeIfAbsent(word.length(), k -> new HashSet<>()).add(word);
        }

        // Sort the array in descending order of length of the word
        // cuz, we are searching for predecessor by removing each char in the word
        Arrays.sort(words, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        for (String word : words) {
            dfs(words, new StringBuilder(word), map, dp);
        }

        System.out.println(dp);
        return Collections.max(dp.values());
    }
}
