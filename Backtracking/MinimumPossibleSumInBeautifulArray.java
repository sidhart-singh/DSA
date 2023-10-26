package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class MinimumPossibleSumInBeautifulArray {
    private long dfs(int n, int target, int index, Set<Integer> set) {
        if (set.size() == n)
            return set.stream().reduce(0, Integer::sum);

        if (!set.contains(index) && !set.contains(target - index)) {
            set.add(index);
            dfs(n, target, index + 1, set);
            if (set.size() == n)
                return set.stream().reduce(0, Integer::sum);
            // no duplicates : so can just remove 'index'
            set.remove(index);
        }

        dfs(n, target, index + 1, set);

        return 0;
    }

    public long minimumPossibleSum(int n, int target) {
        Set<Integer> set = new HashSet<>();
        return dfs(n, target, 1, set);
    }
}
