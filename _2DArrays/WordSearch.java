package _2DArrays;

import java.util.HashSet;

public class WordSearch {

    // Optimized Code
    private boolean visited[][];

    public boolean exist1(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs1(board, i, j, 0, word))
                    return true;
            }
        }
        System.gc();
        return false;

    }

    public boolean dfs1(char[][] board, int i, int j, int index, String word) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)
                || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs1(board, i + 1, j, index + 1, word)
                || dfs1(board, i - 1, j, index + 1, word)
                || dfs1(board, i, j + 1, index + 1, word)
                || dfs1(board, i, j - 1, index + 1, word);
        visited[i][j] = false;
        return found;
    }

    // own code
    private class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + i;
            result = prime * result + j;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            return i == other.i && j == other.j;
        }

    }

    private boolean dfs(char[][] board, String word, int wi, HashSet<Pair> visited, int i, int j) {
        if (i >= board.length || j >= board[0].length || wi > word.length())
            return false;
        if (wi == word.length())
            return true;

        boolean res = false;

        // Node
        // 1. index within bounds
        // 2. index not visited
        // 3, char is equal
        if (i - 1 >= 0 && !visited.contains(new Pair(i - 1, j)) &&
                board[i - 1][j] == word.charAt(wi)) {
            visited.add(new Pair(i - 1, j));
            res = res || dfs(board, word, wi + 1, visited, i - 1, j);
            visited.remove(new Pair(i - 1, j));
        }

        if (i + 1 < board.length && !visited.contains(new Pair(i + 1, j)) &&
                board[i + 1][j] == word.charAt(wi)) {
            visited.add(new Pair(i + 1, j));
            res = res || dfs(board, word, wi + 1, visited, i + 1, j);
            visited.remove(new Pair(i + 1, j));
        }

        if (j + 1 < board[0].length && !visited.contains(new Pair(i, j + 1)) &&
                board[i][j + 1] == word.charAt(wi)) {
            visited.add(new Pair(i, j + 1));
            res = res || dfs(board, word, wi + 1, visited, i, j + 1);
            visited.remove(new Pair(i, j + 1));
        }

        if (j - 1 >= 0 && !visited.contains(new Pair(i, j - 1)) &&
                board[i][j - 1] == word.charAt(wi)) {
            visited.add(new Pair(i, j - 1));
            res = res || dfs(board, word, wi + 1, visited, i, j - 1);
            visited.remove(new Pair(i, j - 1));
        }

        return res;

    }

    public boolean exist(char[][] board, String word) {
        HashSet<Pair> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited.clear();
                    visited.add(new Pair(i, j));
                    if (dfs(board, word, 1, visited, i, j))
                        return true;
                }
            }
        }

        return false;
    }

}
