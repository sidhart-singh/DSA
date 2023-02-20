package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // MinFuelCostToCapital mfctc = new MinFuelCostToCapital();
        // // [[0,1],[0,2],[0,3]]
        // // [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]
        // System.out.println(mfctc.minimumFuelCost(new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}, 2));
        

        // PathWithMaxProb pwmp = new PathWithMaxProb();
        // System.out.println(pwmp.maxProbability(5, new int[][]{{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}}, new double[]{0.37,0.17,0.93,0.23,0.39,0.04}, 3, 4));
    
        EmployeeImportance ei = new EmployeeImportance();
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        listOfEmployees.add(new Employee(2, 3, Arrays.asList()));
        listOfEmployees.add(new Employee(3, 3, Arrays.asList()));
        
        System.out.println(ei.getImportance(listOfEmployees, 1));
    
    }
}
