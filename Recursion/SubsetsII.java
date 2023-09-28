package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private void dfs(int[] nums, int index, List<Integer> subSet, List<List<Integer>> result) {
        // base
        if (index == nums.length) {
            result.add(List.copyOf(subSet));
            return;
        }

        // Node
        // Change
        subSet.add(nums[index]);

        // Left
        dfs(nums, index + 1, subSet, result);

        // undo change
        subSet.remove(subSet.size() - 1);

        // Right
        // while current element is equals to the next & is in bounds : ignore all
        // duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            index++;

        dfs(nums, index + 1, subSet, result);

    }

    private void dfsI(int[] nums, int index, List<Integer> subSet, List<List<Integer>> result) {
        // No base Case required

        result.add(new ArrayList<Integer>(subSet));
        for (int i = index; i < nums.length; i++) {
            // ignore duplicates
            if (i != index && nums[i] == nums[i - 1])
                continue;

            // changes
            subSet.add(nums[i]);
            // children
            dfsI(nums, i + 1, subSet, result);
            // undo changes
            subSet.remove(subSet.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        Arrays.sort(nums);
        // dfs(nums, 0, subSet, result);
        dfsI(nums, 0, subSet, result);

        return result;
    }

}
