package _2DArrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    // TC - O(n^2) SC - O(n)
    public boolean isValidSudoku1(char[][] board) {
        Set<String> seen = new HashSet<>();
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

    // TODO : NOT WORKING
    // TC - O(n^3) SC - O(1) - Striver's
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                char c = board[row][col];
                if (board[row][col] != '.') {
                    for (int i = 0; i < 9; i++) {
                        if (board[i][col] == c)
                            return false;
                        if (board[row][i] == c)
                            return false;
                        if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}