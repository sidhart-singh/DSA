package _2DArrays;

import java.util.Arrays;

public class CountSubmatricesOfEqualFreq {
    // 2d DP => 1d DP
    public int numberOfSubmatrices(char[][] grid) {
        int res = 0;
        int[][] prefixSum = new int[grid.length + 1][grid[0].length + 1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                if (grid[i][j] == 'X') {
                    grid[i][j] = '1';
                    cur = 1;
                } else if (grid[i][j] == 'Y') {
                    grid[i][j] = (char) -1;
                    cur = -1;
                } else if (grid[i][j] == '.') {
                    grid[i][j] = '0';
                    cur = 0;
                }

                // storing prefix sum : sum from left
                if (j > 0)
                    prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + cur;
                else
                    prefixSum[i + 1][j + 1] = cur;
            }
        }

        // System.out.println(Arrays.deepToString(prefixSum));

        // check sum of submatrices
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[0].length; j++) {
                // prefixSum[i][j] = sum from left to self
                // prefixSum[i - 1][j] = sum of column without self (updating at end)
                int sum = prefixSum[i - 1][j] + prefixSum[i][j];
                if (sum == 0) {
                    res++;
                }

                // updating to store vertical prefixSum (sum of top)
                prefixSum[i][j] = sum;
            }
        }

        // System.out.println(Arrays.deepToString(prefixSum));
        // System.out.println(res);

        return res;
    }

    // optimal
    public int numberOfSubmatricesOptimal(char[][] A) {
        int n = A.length, m = A[0].length, res = 0;
        int[][] X = new int[n + 1][m + 1], Y = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                X[i + 1][j + 1] = X[i][j + 1] + X[i + 1][j] - X[i][j] + (A[i][j] == 'X' ? 1 : 0);
                Y[i + 1][j + 1] = Y[i][j + 1] + Y[i + 1][j] - Y[i][j] + (A[i][j] == 'Y' ? 1 : 0);
                if (X[i + 1][j + 1] == Y[i + 1][j + 1] && X[i + 1][j + 1] > 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
