package Recursion;

import java.util.HashMap;
import java.util.Map;

// TODO : WRONG
public class MaxScoreWordsFormedByLetters {

    private void dfs(String[] words, char[] letters, int[] score, Map<Character, Integer> map,
            Map<String, Map<Character, Integer>> wmap, int index, int[] taken, int sum, int[] res) {
        if (index == words.length) {
            res[0] = Math.max(res[0], sum);
            return;
        }

    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Map<Character, Integer>> wmap = new HashMap<>();
        int[] taken = new int[words.length];
        int[] res = { 0 };
        int sum = 0;

        for (char c : letters)
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (String word : words) {
            wmap.put(word, new HashMap<>());
            Map<Character, Integer> m = wmap.get(word);
            for (char c : word.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
        }

        dfs(words, letters, score, map, wmap, 0, taken, sum, res);
        System.out.println(res[0]);

        return res[0];
    }
}
