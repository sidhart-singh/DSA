package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProbabilityTwoBoxesWSameDistinctBalls {
    // db : distinct balls in each box
    private void dfs(int totBalls, Map<Integer, Integer> map, int level, Map<Integer, Integer> pmap,
            int[] db, List<Integer> perm, int[] res) {
        if (level == totBalls / 2)
            db[0] = pmap.size(); // # distinct balls in box 1

        if (level == totBalls) {
            if (db[0] == pmap.size())
                res[0]++;
            return;
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int col = e.getKey();
            int cnt = e.getValue();
            if (cnt == 0)
                continue;
            e.setValue(cnt - 1);
            perm.add(col);
            pmap.put(col, pmap.getOrDefault(col, 0) + 1);
            dfs(totBalls, map, level + 1, pmap, db, perm, res);
            pmap.put(col, pmap.get(col) - 1);
            if (pmap.get(col) == 0)
                pmap.remove(col);
            perm.remove(perm.size() - 1);
            e.setValue(cnt);
        }
    }

    public double getProbability(int[] balls) {
        List<Integer> perm = new ArrayList<>();
        int totBalls = 0;
        // {color : count of balls of this color}
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < balls.length; i++) {
            map.put(i + 1, balls[i]);
            totBalls += balls[i];
        }
        System.out.println(map);

        // count of perms with same number of distinct balls in each box
        int[] res = new int[] {};

        // count of distinct balls in each box
        int[] lc = new int[] {};
        // map for keeping count of balls in a perm
        Map<Integer, Integer> pmap = new HashMap<>();

        dfs(totBalls, map, 0, pmap, lc, perm, res);
        System.out.println(Arrays.toString(res));

        return (double) 0
    }
}
