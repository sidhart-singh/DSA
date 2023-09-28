package Recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxCompatibilityScoreSum {
    private int dfs(int[][] students, int[][] mentors, Map<Integer, Integer> smap, Map<Integer, Set<Integer>> mmap,
            int index, int n) {
        if (index == smap.size())
            return 0;

        int res = 0;
        for (int i = index; i < students.length; i++) {
            int c = smap.get(i);
            int mc = 0;
            res = 0;

            for (int j = 0; j < mentors.length; j++) {
                mc = mmap.get(Integer.valueOf(c));
                mmap.get(c).remove(Integer.valueOf(m));
                res = Math.max(res, c + dfs(students, mentors, smap, mmap, index + 1, n));
                mmap.get(c).add(mc);
            }
        }
        return res;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        Map<Integer, Integer> smap = new HashMap<>(); // {index : #YES}
        Map<Integer, Set<Integer>> mmap = new HashMap<>(); // {#YES : [indeces]}

        int m = students.length;
        int n = students[0].length; // # of questions

        for (int i = 0; i < students.length; i++) {
            int sc = 0;
            int mc = 0;
            for (int j = 0; j < students[i].length; j++) {
                if (students[i][j] == 1)
                    sc++;
                if (mentors[i][j] == 1)
                    mc++;
            }
            smap.put(i, sc);
            mmap.computeIfAbsent(mc, k -> new HashSet<>()).add(i);
        }
        System.out.println(smap);
        System.out.println(mmap);

        System.out.println(dfs(students, mentors, smap, mmap, 0, n));

        return 0;
    }
}
