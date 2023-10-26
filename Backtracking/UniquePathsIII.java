package Backtracking;

public class UniquePathsIII {
    private void dfs(int[][] grid, int[][] dir, int row, int col, int valid, int[] res) {
        if (grid[row][col] == 2) {
            // not 0 : -1 since this is the next call
            if (valid == -1)
                res[0]++;
            return;
        }
        for (int[] d : dir) {
            if ((row + d[0] >= 0 && row + d[0] < grid.length) &&
                    (col + d[1] >= 0 && col + d[1] < grid[0].length) &&
                    grid[row + d[0]][col + d[1]] != -1) {
                int v = grid[row + d[0]][col + d[1]];
                if (v != 2) // if v = 2 : don't change it : checking as base condition
                    grid[row + d[0]][col + d[1]] = -1;
                dfs(grid, dir, row + d[0], col + d[1], valid - 1, res);
                grid[row + d[0]][col + d[1]] = v;
            }
        }
    }

    public int uniquePathsIII(int[][] grid) {
        // int[][] visited = new int[grid.length][grid[0].length];
        int[][] dir = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        int[] res = { 0 };

        int valid = 0;
        int irow = 0, icol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    valid++;
                if (grid[i][j] == 1) {
                    irow = i;
                    icol = j;
                }
            }
        }

        grid[0][0] = -1;
        dfs(grid, dir, irow, icol, valid, res);
        System.out.println(res[0]);

        return res[0];
    }
}
