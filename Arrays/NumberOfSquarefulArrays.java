package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSquarefulArrays {

    private boolean isPerfectSquare(int n) {
        if (n >= 0) {
            int sr = (int) Math.sqrt(n);
            return ((sr * sr) == n);
        }
        return false;
    }

    private void dfs(int n, List<Integer> subList, int[] result, Map<Integer, Integer> count) {
        // base
        if (subList.size() == n) {
            System.out.println(subList);
            result[0]++;
            return;
        }

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            boolean added = false;
            // Node
            // changes
            if (e.getValue() == 0)
                continue;
            if (subList.size() >= 1) {
                if (isPerfectSquare(subList.get(subList.size() - 1) + e.getKey())) {
                    count.put(e.getKey(), e.getValue() - 1);
                    subList.add(e.getKey());
                    added = true;
                } else
                    continue;
            } else {
                count.put(e.getKey(), e.getValue() - 1);
                subList.add(e.getKey());
                added = true;
            }
            // children
            dfs(n, subList, result, count);

            // undo changes
            if (added) {
                count.put(e.getKey(), count.get(e.getKey()) + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public int numSquarefulPerms(int[] nums) {
        // use int[] : to pass by reference
        int[] result = { 0 };
        List<Integer> subList = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);

        dfs(nums.length, subList, result, count);

        return result[0];
    }
}
