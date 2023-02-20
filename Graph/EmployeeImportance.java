package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates){
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};


public class EmployeeImportance {

    class Pair{
        int imp;
        List<Integer> subord;

        public Pair(int imp, List<Integer> subord){
            this.imp = imp;
            this.subord = subord;
        }

        @Override
        public String toString(){
            return this.imp + ", " + this.subord;
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer, Pair> adj = new HashMap<>();
        for(Employee e : employees){
            // if(!adj.containsKey(e.id)){
                // adj.put(e.id, new Pair(e.importance, new ArrayList<>(e.subordinates)));
            // }
            adj.put(e.id, new Pair(e.importance, new ArrayList<>(e.subordinates)));

        }
        // adj.forEach((key, value) -> System.out.println(key + " : " + value));

        int totalImportance = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        while(!queue.isEmpty()){
            // not needed : id is always valid
            // if(!adj.containsKey(queue.peek())) break;

            int ceid = queue.poll();
            totalImportance += adj.get(ceid).imp;

            for(int eid : adj.get(ceid).subord) queue.add(eid);
        }

        return totalImportance;
    }
}
