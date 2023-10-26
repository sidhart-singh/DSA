package Backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * TODO:
 * color{
 *  type_of_color : set_of_nodes_with_color
 * }
 */
public class FlowerPlantingNoAdjacent {
    private boolean isValid(int node, int type, Map<Integer, Set<Integer>> neigh, Map<Integer, Integer> color) {
        // no neighbours : all the color types valid
        if (!neigh.containsKey(node))
            return true;
        for (Integer neig : neigh.get(node)) {
            if (color.containsKey(neig) && color.get(neig) == type)
                return false;
        }
        return true;
    }

    private boolean dfs(int node, int n, Map<Integer, Set<Integer>> neigh, Map<Integer, Integer> color, int[] res) {
        if (node == n + 1)
            return true;
        for (int i = 1; i < 5; i++) {
            if (isValid(node, i, neigh, color)) {
                color.put(node, i);
                res[node - 1] = i;
                // return on the first possible correct color combination
                if (dfs(node + 1, n, neigh, color, res))
                    return true;
                color.remove(node);
            }
        }
        return false;
    }

    private void neighMap(int n, int[][] paths, Map<Integer, Set<Integer>> neigh) {
        // for (int i = 0; i <= n; i++)
        // neigh.put(i, new HashSet<>());
        for (int[] p : paths) {
            if (neigh.containsKey(p[0]))
                neigh.get(p[0]).add(p[1]);
            else
                neigh.put(p[0], new HashSet<>(Arrays.asList(p[1])));

            if (neigh.containsKey(p[1]))
                neigh.get(p[1]).add(p[0]);
            else
                neigh.put(p[1], new HashSet<>(Arrays.asList(p[0])));
        }
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        Map<Integer, Set<Integer>> neigh = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();

        neighMap(n, paths, neigh);
        System.out.println(neigh);

        dfs(1, n, neigh, color, res);

        System.out.println(Arrays.toString(res));
        return res;
    }
}
