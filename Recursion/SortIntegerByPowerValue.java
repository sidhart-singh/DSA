package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortIntegerByPowerValue {
    private int dfs(int i, Map<Integer, Integer> dp) {
        if (i == 1)
            return 0;
        if (dp.containsKey(i))
            return dp.get(i);

        int res = 0;
        if (i % 2 == 0) {
            res = 1 + dfs(i / 2, dp);
        } else {
            res = 1 + dfs(i * 3 + 1, dp);
        }

        dp.put(i, res);
        return res;
    }

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        List<int[]> res = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            res.add(i - lo, new int[] { i, dfs(i, dp) });
        }

        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        res.forEach(s -> System.out.println(Arrays.toString(s)));

        return res.get(k - 2)[0];
    }
}
