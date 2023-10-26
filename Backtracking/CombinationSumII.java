package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, 0, temp, results);

        return results;
    }

    private void backtrack(int[] candidates, int target, int index, int sum, List<Integer> temp,
            List<List<Integer>> results) {
        if (sum == target) {
            results.add(List.copyOf(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] + sum > target)
                break;

            temp.add(candidates[i]);
            sum += candidates[i];

            backtrack(candidates, target, i + 1, sum, temp, results);

            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);

        }

    }
}
