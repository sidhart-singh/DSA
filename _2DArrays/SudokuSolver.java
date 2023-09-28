package _2DArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public boolean isValidSudoku(char[][] board, Set<String> seen) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    private boolean dfs(int row, int col, char[][] board) {
        if (row >= board.length && col >= board[0].length)
            return true;
        if (col == board[0].length)
            return dfs(row + 1, 0, board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 10; k++) {
                        if (isValid(i, j, board, Character.forDigit(k, 10))) {
                            // if (!seen.contains(k + " in row " + i) &&
                            // !seen.contains(k + " in column " + j) &&
                            // !seen.contains(k + " in block " + i / 3 + "-" + j / 3)) {
                            board[i][j] = Character.forDigit(k, 10);
                            // seen.add(k + " in row " + i);
                            // seen.add(k + " in column " + j);
                            // seen.add(k + " in block " + i / 3 + "-" + j / 3);

                            if (dfs(row, col + 1, board))
                                return true;

                            board[i][j] = '.';
                            // seen.remove(k + " in row " + i);
                            // seen.remove(k + " in column " + j);
                            // seen.remove(k + " in block " + i / 3 + "-" + j / 3);
                        }
                    }
                    return false;
                }
            }
        }

        return true;

    }

    private boolean isValid(int row, int col, char[][] board, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        // Set<String> seen = new HashSet<>();
        // isValidSudoku(board, seen);
        // using hashset and isValidSudoku() to check whether a value is valid for a
        // cell
        // dfs(0, 0, board, seen);

        // using isValid() to check whether a value is valid for a cell
        dfs(0, 0, board);
        // System.out.println(Arrays.deepToString(board));
    }
}
