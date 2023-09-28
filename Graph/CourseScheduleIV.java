package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleIV{
    // public List<Boolean> checkIfPrerequisiteI(int numCourses, int[][] prerequisites, int[][] queries) {
        
    //     List<Boolean> result = new ArrayList<>();
    //     HashMap<Integer, Set<Integer>> adj = new HashMap<>();

    //     // Adjacency List
    //     for(int[] p : prerequisites){
    //         if(adj.containsKey(p[1]))
    //             adj.get(p[1]).add(p[0]);
    //         else 
    //             adj.put(p[1], new HashSet<Integer>(Arrays.asList(p[0])));
    //     }
    //     System.out.println(adj);

    //     /* 
    //         indirect dependencies with greater indirection are not added :
    //         [2, 4](2 is a dependency of 4) 
    //         1st : creating intial map (direct dependencies) : 4 -> 2
    //         2nd : (indirect dependencies) : 4 -> 2 -> 3
    //         ... this indirection could go on for O(n) : 
    //         2xNested loop takes care of 2xLevel indirection
    //     */
    //     // for(Map.Entry<Integer, Set<Integer>> e : map.entrySet()){
    //     //     Set<Integer> currSet = new HashSet<>(new ArrayList<>(e.getValue()));
    //     //     for(Integer p : e.getValue()){
    //     //         if(map.containsKey(p)){ 
    //     //             currSet.addAll(map.get(p));
    //     //         }
    //     //     }
    //     //     e.setValue(currSet);
    //     // }

    //     HashMap<Integer, Boolean> visited = new HashMap<>();
    //     HashMap<Integer, Set<Integer>> map = new HashMap<>();
    //     for(Map.Entry<Integer, Set<Integer>> e : adj.entrySet())
    //         if(!map.containsKey(e.getKey()))
    //             map.put(e.getKey(), new HashSet<>(dfs(adj, visited, e.getKey())));
    //         else
    //             map.get(e.getKey()).addAll(dfs(adj, visited, e.getKey()));

    //     for(int[] q : queries){
    //         if(map.containsKey(q[1]) && map.get(q[1]).contains(q[0])) 
    //             result.add(true);
    //         else 
    //             result.add(false);
    //     }

    //     System.out.println(map);
    //     // System.out.println(result);

    //     return result;
    // }

    // public List<Integer> dfsI(HashMap<Integer, Set<Integer>> adj, HashMap<Integer, Boolean> visited, int node){

    //     // Base Case : Node doesn't have any dependencies
    //     if(!adj.containsKey(node)){
    //         visited.put(node, true);
    //         return new ArrayList<>(Arrays.asList(node));
    //     }

    //     ArrayList<Integer> dep = new ArrayList<>();


    //     for(Integer nei : adj.get(node)){
    //         // if the neighbour is already visited : 
    //         // base
    //         if(visited.containsKey(nei) && visited.get(nei)){
    //             // if neighbour is in adj : else NullPointerException (adj.get(nei))
    //             if(adj.containsKey(nei))
    //                 // return the dependencies from the adj
    //                 dep.addAll(adj.get(nei));
    //         } 
    //         // else 
    //         else {
    //             // get the current node's dependencies (recursivly)
    //             dep.addAll(dfs(adj, visited, nei));

    //             // update the current node's dependencies in the adj
    //             adj.get(node).addAll(dep);
    //         }
    //     }
    //     // mark the current node visited
    //     visited.put(node, true);
    //     // add the current node to the depList for its parent
    //     dep.add(node);

    //     return dep;
    // }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries){

        List<Boolean> result = new ArrayList<>();

        // building an adjacency list
        // Course -> List(prereq)
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e : prerequisites){
            if(adj.containsKey(e[1]))
                adj.get(e[1]).add(e[0]);
            else
                adj.put(e[1], new ArrayList<>(Arrays.asList(e[0])));
        }

        // building a prereq map (direct and indirect prereq) using dfs
        // Course -> Set(prereq)
        HashMap<Integer, Set<Integer>> prereqMap = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> e : adj.entrySet()){
            
            dfs(adj, prereqMap, e.getKey());
        }

        for(int[] q : queries){
            if(prereqMap.containsKey(q[1]))
                result.add(prereqMap.get(q[1]).contains(q[0]));
        }

        return result;

    }

    public Set<Integer> dfs(HashMap<Integer, List<Integer>> adj, HashMap<Integer, Set<Integer>> prereqMap, int course){
        if(!prereqMap.containsKey(course)){

            prereqMap.put(course, new HashSet<Integer>());

            for(int prereq : adj.get(course)){
                if(adj.containsKey(prereq))
                    prereqMap.put(course, dfs(adj, prereqMap, prereq));
                else
                    prereqMap.get(course).add(prereq);
            }

            prereqMap.get(course).add(course);
        }

        return prereqMap.get(course);
    }

}