package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> subList) {
        // base case
        if (index == nums.length)
            return;

        for (int i = index; i < nums.length; i++) {
            // Node
            // changes
            subList.add(nums[i]);
            result.add(List.copyOf(subList));

            // children
            dfs(nums, i + 1, result, subList);

            // undo changes
            subList.remove(subList.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        result.add(List.copyOf(subList));

        dfs(nums, 0, result, subList);

        return result;
    }
}
