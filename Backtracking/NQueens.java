package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Use hashmap to check isValid : Striver
public class NQueens {

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

    private void dfs(int n, int col, List<char[]> board, List<List<String>> res) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            board.forEach(s -> temp.add(String.valueOf(s)));

            res.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(i, col, board)) {
                board.get(col)[i] = 'Q';

                dfs(n, col + 1, board, res);

                board.get(col)[i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<char[]> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            board.add(c);
        }
        // board.get(0)[1] = 'Q';
        // System.out.println(board);

        dfs(n, 0, board, res);

        System.out.println(res);
        return res;
    }
}
