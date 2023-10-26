package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MaxSplitPositiveEvenIntegers {
    private void dfs(long n, long i, List<Long> t, List<Long> res) {
        if (n <= 0) {
            if (t.size() > res.size()) {
                res.clear();
                res.addAll(t);
            }
            return;
        }

        for (long j = i; j <= n; j += 2) {
            if (n - j >= 0) {
                t.add(j);
                dfs(n - j, j + 2, t, res);
                t.remove(j); // no duplicates : no need to explicitly remove the last entry
            }
        }
    }

    public List<Long> maximumEvenSplit(long n) {
        List<Long> t = new ArrayList<>();
        List<Long> res = new ArrayList<>();

        if (n % 2 == 0) {
            dfs(n, 0, t, res);
            if (!res.isEmpty())
                res.remove(0);
        }
        System.out.println(res);

        return res;
    }
}