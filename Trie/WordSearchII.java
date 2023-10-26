package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordSearchII {

    // Brute Force - DFS
    private boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs1(board, i, j, 0, word))
                    return true;
            }
        }
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

    // TLE - using brute force like wordSearch.java
    public List<String> findWords1(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (exist(board, word))
                res.add(word);
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, Trie trie, String prefix, HashSet<String> res, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || !trie.startsWith(prefix + board[i][j]))
            return;

        // Node
        if (trie.search(prefix + board[i][j]))
            res.add(prefix + board[i][j]);
        // change
        visited[i][j] = true;

        // Children
        dfs(board, i + 1, j, trie, prefix + board[i][j], res, visited);
        dfs(board, i, j + 1, trie, prefix + board[i][j], res, visited);
        dfs(board, i, j - 1, trie, prefix + board[i][j], res, visited);
        dfs(board, i - 1, j, trie, prefix + board[i][j], res, visited);

        // undo change
        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (var v : visited)
            Arrays.fill(v, false);

        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.startsWith(String.valueOf(board[i][j]))) {
                    visited[i][j] = true;
                    dfs(board, i, j, trie, "", res, visited);
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(res);
        return res.stream().collect(Collectors.toList())
    }

}
