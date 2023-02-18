package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaxProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        class Pair implements Comparable<Pair>{
            int node;
            double prob;

            Pair(int node, double prob){
                this.node = node;
                this.prob = prob;
            }

            @Override
    public int compareTo(Pair p) {
        if(this.prob > p.prob) {
            return 1;
        } else if (this.prob < p.prob) {
            return -1;
        } else {
            return 0;
        }
    }
        }


        // create adjacency list from edges[][]
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            // source -> destination
            if(!adj.containsKey(edges[i][0])){
                adj.put(edges[i][0], new ArrayList<>(List.of(new Pair(edges[i][1], succProb[i]))));
            } else {
                adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            }

            // destination -> source
            if(!adj.containsKey(edges[i][1])){
                adj.put(edges[i][1], new ArrayList<>(List.of(new Pair(edges[i][0], succProb[i]))));
            } else {
                adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
            }
        }


        // Dijkstra using MaxHeap : Maximize the probability

        // maxProb : no need to maintain
        // prev : no need to maintain : path is not to be returned

        // creating visited set to store the nodes which are visited once
        HashSet<Integer> visited = new HashSet<>();
        
        // creating a MaxHeap
        // PriorityQueue<Pair> heap = new PriorityQueue<>((pair_a, pair_b) -> (int)(pair_b.prob - pair_a.prob));
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.reverseOrder());

        // adding the source:Probability - 0 : 1
        heap.add(new Pair(start, 1));
        while(!heap.isEmpty()){
            // removing the node with max probability
            Pair current = heap.poll();

            // marking the current node as visited
            visited.add(current.node);

            /*
             * maxProb is not maintained :
             * when a neighbour is added, the probability to reach it from the parent is maintained :
             * heap.add(new Pair(pair.node, current.prob * pair.prob));
             */
            if(current.node == end)
                return current.prob;

            // adding all the neighbours to the heap with updated probability :
                // only if the adjacency list contains the node :
                // TestCase : n:500, edges:[[193,229],[133,212],[224,465]], prob:[0.91,0.78,0.64], start:4, end:394
                // no edge from node 4 : no entry in the adjacency list
            if(adj.containsKey(current.node))
                for(Pair nei : adj.get(current.node)){
                    if(!visited.contains(nei.node))
                        heap.add(new Pair(nei.node, current.prob * nei.prob));
                }

        }

        // if theres no path from the source to target node
        return 0;
    }
}
