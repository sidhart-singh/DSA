package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    // DAG : so we don't need to maintain a 'visited' set
    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int neigh : graph[node]) {
            path.add(neigh);
            dfs(graph, neigh, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, path, res);

        return res;
    }
}
