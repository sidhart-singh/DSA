package Backtracking;

import java.util.HashSet;
import java.util.Set;

// TODO: Add Memoization - DP
public class BeautifulArrangement {
    private void dfs(int n, int index, Set<Integer> perm, int[] res) {
        // initial index - 1 : acc. to question - '1-indexed'
        // so base also increment by 1
        if (index == n + 1) {
            res[0]++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (((index != 0 && i % index == 0) || (index % i == 0))
                    && !perm.contains(i)) {
                perm.add(i);
                dfs(n, index + 1, perm, res);
                // remove 'i' not 'perm.size() - 1' : unordered
                perm.remove(i);
            }
        }
    }

    public int countArrangement(int n) {
        // Generating all permutations with each number once : so using 'set'
        int[] res = { 0 };
        Set<Integer> perm = new HashSet<>();
        // Map<Integer, Set<Integer>> dp = new HashMap<>();

        // initial index - 1 : acc. to question - '1-indexed'
        dfs(n, 1, perm, res);
        System.out.println(res[0]);

        return res[0];
    }
}
