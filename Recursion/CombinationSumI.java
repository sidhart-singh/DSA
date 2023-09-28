package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(candidates, 0, target, 0, temp, results);

        return results;
    }

    private void backtrack(int[] a, int index, int target, int total, List<Integer> temp, List<List<Integer>> result) {
        if (total == target) {
            result.add(List.copyOf(temp));
            return;
        }
        if (index >= a.length || total > target) {
            return;
        }

        temp.add(a[index]);
        backtrack(a, index, target, total + a[index], temp, result);

        temp.remove(temp.get(temp.size() - 1));
        backtrack(a, index + 1, target, total, temp, result);

    }

}
