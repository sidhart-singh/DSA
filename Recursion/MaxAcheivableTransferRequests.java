package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAcheivableTransferRequests {
    public int maximumRequests(int n, int[][] requests) {
        // {Node - List of requests}
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] r : requests)
            map.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);

        System.out.println(map);

        return 0;
    }
}
