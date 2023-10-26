package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CombinationSumIII {

    private void dfs(int[] nums, int n, int k, int index, List<List<Integer>> result,
            List<Integer> subList) {
        // base cases
        if (subList.size() == k && n == 0) // NOT RETURNING
            result.add(List.copyOf(subList));
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            subList.add(nums[i]);

            dfs(nums, n - nums[i], k, i + 1, result, subList);

            subList.remove(subList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = IntStream.rangeClosed(1, 9).toArray();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        dfs(nums, n, k, 0, result, subList);
        // System.out.println(result);

        // System.gc();
        return result;
    }
}
