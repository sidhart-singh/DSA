package Backtracking;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities {
    // NOTE:
    /*
     * 1. 'cpos' = count of positive entries in freq map
     * 
     * 2. cannot remove (modify) an entry from the map while traversing
     * therefore, need an extra variable to maintain the 'cpos'
     * 
     * 3. return value
     * need to return '1' for each call
     * so, sum += '1' + dfs() call
     * and on base case return '0' other wise adding extra 1 for each base case.
     */
    private int dfs(Map<Character, Integer> freq, int cpos, int n) {
        if (cpos == 0) {
            return 0;
        }

        int sum = 0;
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > 0) {
                freq.put(e.getKey(), freq.get(e.getKey()) - 1);
                if (freq.get(e.getKey()) == 0)
                    cpos--;

                sum += 1 + dfs(freq, cpos, n);
                if (freq.get(e.getKey()) == 0)
                    cpos++;
                freq.put(e.getKey(), freq.getOrDefault(e.getKey(), 0) + 1);
            }
        }

        return sum;
    }

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tiles.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        return dfs(freq, freq.size(), tiles.length());
    }
}
