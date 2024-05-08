package Backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// TODO: Not working dfs1
// submitted anohter solution
public class MaximixeAfterNOperations {

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // BRUTE FORCE: RECURSION
    private int dfs(int[] nums, boolean[] visited, int level) {
        int maxScore = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (visited[i])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (visited[j])
                    continue;
                visited[i] = true;
                visited[j] = true;
                // =====================================================================
                int currScore = level * gcd(nums[i], nums[j]);
                int nextMaxScore = dfs(nums, visited, level + 1);
                int totalScore = currScore + nextMaxScore;
                maxScore = Math.max(maxScore, totalScore);
                // ======================================================================
                visited[i] = false;
                visited[j] = false;
            }
        }
        return maxScore;
    }

    // DP: MEMOIZATION
    private int dfs1(int[] nums, boolean[] visited, int level, Map<boolean[], Integer> dp) {
        if (dp.containsKey(visited))
            return dp.get(visited); // use stored result

        int maxScore = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (visited[i])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (visited[j])
                    continue;
                visited[i] = true;
                visited[j] = true;
                // =====================================================================
                int currScore = level * gcd(nums[i], nums[j]);
                int nextMaxScore = dfs1(nums, visited, level + 1, dp);
                int totalScore = currScore + nextMaxScore;
                maxScore = Math.max(maxScore, totalScore);
                // ======================================================================
                visited[i] = false;
                visited[j] = false;
            }
        }
        dp.put(visited, maxScore);
        return maxScore
    }

    public int maxScore(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Map<boolean[], Integer> dp = new HashMap<>();

        int res = dfs1(nums, visited, 1, dp);

        System.out.println(res);
        return res;
    }
}
