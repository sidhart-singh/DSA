package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxDiffScoreGrid {
    private int dfs(List<List<Integer>> grid, int i, int j, int[][] dp) {
        if (i > grid.size() - 1 || j > grid.get(0).size() - 1)
            return 0;
        if (i == grid.size() - 1 && j == grid.get(i).size() - 1)
            return grid.get(i).get(j);
        if (dp[i][j] != -1)
            return dp[i][j];

        int res = 0;
        
        for(int k = 0; k < grid.size(); k++){
            
        }

        dp[i][j] = res;
        return res - grid.get(i).get(j);
    }

    public int maxScore(List<List<Integer>> grid) {
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[grid.size()][grid.get(0).size()];
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, -1));

        for (int i = 0; i < grid.size(); i++) {
            var t = grid.get(i);
            for (int j = 0; j < t.size(); j++) {
                res = Math.max(res, dfs(grid, i, j, dp));
            }
        }
        System.out.println(res);
        return res;
    }
}
