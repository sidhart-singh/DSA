package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Use hashmap to check isValid : Striver
public class NQueensII {
    private boolean isValid(int i, int j, List<char[]> visited) {
        // check row
        int row = i;
        int col = j;
        while (col >= 0) {
            if (visited.get(col)[row] == 'Q')
                return false;
            col--;
        }

        // check diagonals
        row = i;
        col = j;
        while (row >= 0 && col >= 0) {
            if (visited.get(col)[row] == 'Q')
                return false;
            row--;
            col--;
        }
        row = i;
        col = j;
        while (row < visited.size() && col >= 0) {
            if (visited.get(col)[row] == 'Q')
                return false;
            row++;
            col--;
        }

        return true;
    }

    private int dfs(int n, int col, List<char[]> board) {
        if (col == n)
            return 1;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(i, col, board)) {
                board.get(col)[i] = 'Q';

                res += dfs(n, col + 1, board);

                board.get(col)[i] = '.';
            }
        }

        return res;
    }

    public int solveNQueens(int n) {
        List<char[]> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            board.add(c);
        }
        // board.get(0)[1] = 'Q';
        // System.out.println(board);

        return dfs(n, 0, board);

    }

    // public int totalNQueens(int n) {

    // }
}
