package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxAcheivableTransferRequests {

    public void dfs(int[][] req, int index, int accept, List<Integer> temp, int[] res) {
        if (index == req.length) {
            for (int n : temp)
                if (n != 0)
                    return;
            res[0] = Math.max(res[0], accept);
            return;
        }
        // not accept
        dfs(req, index + 1, accept, temp, res);

        // modify for accept
        temp.set(req[index][0], temp.get(req[index][0]) - 1);
        temp.set(req[index][1], temp.get(req[index][1]) + 1);
        dfs(req, index + 1, accept + 1, temp, res);

        // reverse the change
        temp.set(req[index][0], temp.get(req[index][0]) + 1);
        temp.set(req[index][1], temp.get(req[index][1]) - 1);
    }

    // memoization doesn't improve the solution.
    public int dfs1(int[][] req, int index, int accept, List<Integer> temp, int[] res, Map<Integer, Integer> dp) {
        if (index == req.length) {
            for (int n : temp)
                if (n != 0)
                    return 0;
            return accept;
        }
        if (dp.containsKey(index))
            return dp.get(index);

        // not accept
        res[0] = Math.max(res[0], dfs1(req, index + 1, accept, temp, res, dp));

        // modify for accept
        temp.set(req[index][0], temp.get(req[index][0]) - 1);
        temp.set(req[index][1], temp.get(req[index][1]) + 1);
        res[0] = Math.max(res[0], dfs1(req, index + 1, accept + 1, temp, res, dp));

        // reverse the change
        temp.set(req[index][0], temp.get(req[index][0]) + 1);
        temp.set(req[index][1], temp.get(req[index][1]) - 1);

        return res[0];
    }

    public int maximumRequests(int n, int[][] requests) {

        int[] temp = new int[n];
        Arrays.fill(temp, 0); // initial value = 0
        // List<Integer> tempp = Arrays.stream(temp)
        // .mapToObj(Integer::valueOf)
        // .collect(Collectors.toList());
        Map<Integer, Integer> dp = new HashMap<>();
        List<Integer> tempp = new ArrayList<>(Collections.nCopies(n, 0));
        int[] res = { 0 };

        dfs1(requests, 0, 0, tempp, res, dp);

        System.out.println(res[0]);

        return res[0];
    }
}
