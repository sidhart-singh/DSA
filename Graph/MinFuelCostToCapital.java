package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinFuelCostToCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] road : roads){
            // source : dest
            if(!adj.containsKey(road[0]))
                adj.put(road[0], new ArrayList<>(List.of(road[1])));
            else
                adj.get(road[0]).add(road[1]);

            // dest : source
            if(!adj.containsKey(road[1]))
                adj.put(road[1], new ArrayList<>(List.of(road[0])));
            else
                adj.get(road[1]).add(road[0]);
        }

        // using fuel as array to pass as reference:
        long[] fuel = new long[]{0};
        dfs(adj, seats, 0, -1, fuel);

        return fuel[0];
    }

    public long dfs(HashMap<Integer, List<Integer>> adj, int seats, int node, int parent, long[] fuel){
        
        // for leaf node : base condition
        if(!adj.containsKey(node))
            return 1;

        long passengers = 0;
        for(int nei : adj.get(node)){
            if(nei != parent){
                long p = dfs(adj, seats, nei, node, fuel);
                passengers += p;

                /*
                * compute the fuel required by the neighbours to reach to current node :
                * not including current node 
                *
                * #cars = (int)Math.ceil((double)passengers / seats)
                * fuel required to reach parent  = #cars * distance :
                * fuel = (int)Math.ceil((double)passengers / seats) * 1
                * (node -> parent : distance = 1)
                */
                fuel[0] += (int)Math.ceil((double)p / seats);
            }
        }

        // adding the current node to #passengers
        return passengers + 1;
    }
}
