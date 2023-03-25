package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountUnreachablePairNodes {

    // TODO : Implement using UnionFind

    long nodes = 0;
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public long countPairs(int n, int[][] edges) {

        // create the adjacency list
        for(int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);

            adj.get(edge[1]).add(edge[0]);
        }

        // System.out.println(adj);

        // count pairs : 
        long result = 0;        // total pairs
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                nodes = 0;      // initialize the count to 0 
                dfs(i);         // get count of nodes in each component into 'nodes'
                result += nodes * (n - nodes);      // nodes : long
            }
        }

        // counting each pair twice : divide by 2
        return result / 2;
    }

    // counting number of nodes in the component of the current node
    public void dfs(int node){
        // add current node to visited
        visited.add(node);

        // increment count of node
        nodes++;

        for(int nei : adj.get(node)){
            if(visited.contains(nei))
                continue;
            dfs(nei);
        }
    }

}
