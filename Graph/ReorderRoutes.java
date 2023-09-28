package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Reorder Routes To Make All Paths Lead To Capital
public class ReorderRoutes {

    class Pair {
        int nei;
        boolean isIncoming;

        public Pair(int nei, boolean isIncoming) {
            this.nei = nei;
            // [0, 1] : 0 --> 1
            // adj:
            // 0 : [1, out]
            this.isIncoming = isIncoming;
        }

        public String toString() {
            return "[" + this.nei + ":" + (isIncoming ? "in" : "out") + "]";
        }
    }

    public int minReorder(int n, int[][] connections) {
        int result = 0;
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] node : connections) {
            if (!adj.containsKey(node[0])) {
                adj.put(node[0], new ArrayList<>(Arrays.asList(new Pair(node[1], false))));
            } else {
                adj.get(node[0]).add(new Pair(node[1], false));
            }

            if (!adj.containsKey(node[1])) {
                adj.put(node[1], new ArrayList<>(Arrays.asList(new Pair(node[0], true))));
            } else {
                adj.get(node[1]).add(new Pair(node[0], true));
            }
        }
        System.out.println(adj);

        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        // Capital City : city zero
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();

            for (Pair p : adj.get(node)) {
                if (visited.contains(p.nei))
                    continue;

                // current node having outgoing edge to the neighbour
                if (!p.isIncoming) {
                    result++;
                }

                q.add(p.nei);
                visited.add(p.nei);
            }

            visited.add(node);
        }

        return result;
    }
}
