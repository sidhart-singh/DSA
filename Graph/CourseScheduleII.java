package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> prereqMap = new HashMap<>();
        for(int[] prereq : prerequisites){
            if(prereqMap.containsKey(prereq[0])) 
                prereqMap.get(prereq[0]).add(prereq[1]);
            else
                prereqMap.put(prereq[0], new ArrayList<>(Arrays.asList(prereq[1])));
        }

        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> path = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(prereqMap, i, result, visited, path))
                return new int[]{};
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    public boolean dfs(HashMap<Integer, List<Integer>> adj, int course, ArrayList<Integer> result,
         HashSet<Integer> visited, HashSet<Integer> path){

            // Base Cases :
                // if the current course is already present in the path :
                // there is a cycle
            if(path.contains(course))
                return false;
            
                // if the current course is already visited 
            if(visited.contains(course))
                return true;

                // if the current course is not in adj(prereqMap) :
                // there are no prerequisites for the current course :
                // add current course to visited and result : return
            if(!adj.containsKey(course)){
                visited.add(course);
                result.add(course);
                return true;
            }
                
            // add the current course to the path
            path.add(course);
            // recursively call all the prerequisite courses of the current course
            // if(adj.containsKey(course)){
                for(int prereq : adj.get(course)){
                    if(!dfs(adj, prereq, result, visited, path))
                        return false;
                }
            // }

            // remove the current course from the path
            path.remove(course);
            // add the current course to visited
            visited.add(course);
            // add the current course to result
            result.add(course);

            return true;
    }
}
