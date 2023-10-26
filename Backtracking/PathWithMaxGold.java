package Backtracking;

import java.util.Arrays;

// TODO: working with visited[][] not if modifying og grid
// TODO: returning dfs
public class PathWithMaxGold {
    private int dfs(int[][] grid, int[][] dir, int row, int col, int[][] visited, int sum, int[] res) {
        // No Base Case Neede

        int t = 0;
        int max = 0;
        for (int[] d : dir) {
            if ((row + d[0] >= 0 && row + d[0] < grid.length) &&
                    (col + d[1] >= 0 && col + d[1] < grid[0].length) &&
                    grid[row + d[0]][col + d[1]] != 0) {
                t = grid[row][col];
                grid[row][col] = 0;
                // sum + grid[row + d[0]][col + d[1]] : add the next valid cell to sum
                max = dfs(grid, dir, row + d[0], col + d[1], visited, sum + grid[row + d[0]][col + d[1]], res);
                grid[row][col] = t;
            }
        }

        res[0] = Math.max(res[0], sum + t);
        return max
    }

    public int getMaximumGold(int[][] grid) {
        int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[] res = { 0 };

        int[][] visited = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            int t = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    t = grid[i][j];
                    grid[i][j] = 0;
                    // sum + grid[row + d[0]][col + d[1]] : add the next valid cell to sum
                    max = Math.max(max, dfs(grid, dir, i, j, visited, 0 + grid[i][j], res));
                    grid[i][j] = t;
                    System.out.println(Arrays.deepToString(grid));
                }
            }
        }
        System.out.println(max);
        return max;
    }
}
