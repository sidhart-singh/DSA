package Graph;

public class Main {
    public static void main(String[] args) {
        // MinFuelCostToCapital mfctc = new MinFuelCostToCapital();
        // // [[0,1],[0,2],[0,3]]
        // // [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]
        // System.out.println(mfctc.minimumFuelCost(new
        // int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}, 2));


        // PathWithMaxProb pwmp = new PathWithMaxProb();
        // System.out.println(pwmp.maxProbability(5, new
        // int[][]{{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}}, new
        // double[]{0.37,0.17,0.93,0.23,0.39,0.04}, 3, 4));

        // EmployeeImportance ei = new EmployeeImportance();
        // List<Employee> listOfEmployees = new ArrayList<>();
        // listOfEmployees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        // listOfEmployees.add(new Employee(2, 3, Arrays.asList()));
        // listOfEmployees.add(new Employee(3, 3, Arrays.asList()));

        // System.out.println(ei.getImportance(listOfEmployees, 1));

        // CourseScheduleIV csiv = new CourseScheduleIV();
        // System.out.println(csiv.checkIfPrerequisite(3,
        // new
        // int[][]{{2,1},{2,7},{2,0},{2,10},{2,11},{1,7},{1,0},{1,9},{1,4},{1,11},{7,3},{7,9},{7,4},{7,11},{7,8},{3,6},{3,12},{3,5},{6,10},{6,8},{0,4},{12,9},{12,8},{9,4},{9,11},{9,8},{9,5},{10,8},{4,8}},
        // new
        // int[][]{{12,11},{11,1},{10,12},{9,10},{10,11},{11,12},{2,7},{6,8},{3,2},{9,5},{8,7},{1,4},{3,12},{9,6},{4,3},{11,4},{5,7},{3,9},{3,1},{8,12},{5,12},{0,8},{10,5},{10,11},{12,11},{12,9},{5,4},{11,5},{12,10},{11,0},{6,10},{11,7},{8,10},{2,1},{3,4},{8,7},{11,6},{9,11},{1,4},{10,8},{7,1},{8,7},{9,7},{5,1},{8,10},{11,8},{8,12},{9,12},{12,11},{6,12},{12,11},{6,10},{9,12},{8,10},{8,11},{8,5},{7,9},{12,11},{11,12},{8,0},{12,11},{7,0},{8,7},{5,11},{11,8},{1,9},{4,10},{11,6},{10,12}}
        // ));
        // System.out.println(csiv.checkIfPrerequisite(3,
        // new int[][]{{2, 1}, {2, 5}, {3, 2}, {4, 2}},
        // new int[][]{{3, 5}}));


        // WordLadder wl = new WordLadder();
        // System.out.println(wl.ladderLength("hot", "cog",
        // Arrays.asList("hot","dot","dog","lot","log","cog")));


        ReorderRoutes rr = new ReorderRoutes();
        System.out.println(rr.minReorder(5, new int[][] {{1, 0}, {2, 0}}));;
    }
}
