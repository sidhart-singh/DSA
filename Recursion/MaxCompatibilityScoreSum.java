package Recursion;

// Optimal Solution : DP with Bitmasking
// Here, Brute Force 
public class MaxCompatibilityScoreSum {
    private int dfs(int[][] students, int[][] mentors, int index, boolean[] paired) {
        if (index == students.length)
            return 0;

        int cs = 0; // compatibility score
        int max = 0;
        for (int i = 0; i < mentors.length; i++) {
            if (paired[i])
                continue;

            for (int j = 0; j < students[i].length; j++) {
                if (students[index][j] == mentors[i][j])
                    cs++;
            }
            paired[i] = true;

            cs += dfs(students, mentors, index + 1, paired);

            paired[i] = false;
            max = Math.max(max, cs);
        }

        return max;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] paired = new boolean[mentors.length];
        // Arrays.fill(paired, false);

        return dfs(students, mentors, 0, paired);
    }

    // Memoization : Slower on leetcode
    // private class Pair {
    // int si;
    // int mi;

    // Pair(int si, int mi) {
    // this.si = si;
    // this.mi = mi;
    // }

    // }

    // private int dfs(int[][] students, int[][] mentors, int index, boolean[]
    // paired, Map<Pair, Integer> dp) {
    // if (index == students.length)
    // return 0;

    // int max = 0;
    // for (int i = 0; i < mentors.length; i++) {
    // if (paired[i])
    // continue;

    // int cs = 0; // compatibility score
    // Pair pair = new Pair(index, i);
    // Store the score in dp
    // if (dp.containsKey(pair))
    // cs = dp.get(pair);
    // else {
    // for (int j = 0; j < students[i].length; j++) {
    // if (students[index][j] == mentors[i][j])
    // cs++;
    // }
    // }
    // dp.put(pair, cs);

    // paired[i] = true;
    // cs += dfs(students, mentors, index + 1, paired, dp);

    // paired[i] = false;

    // max = Math.max(max, cs);
    // }
    // return max;
    // }

    // public int maxCompatibilitySum(int[][] students, int[][] mentors) {
    // Map<Pair, Integer> dp = new HashMap<>();
    // boolean[] paired = new boolean[mentors.length];
    // // Arrays.fill(paired, false);

    // return dfs(students, mentors, 0, paired, dp);
    // }
}
