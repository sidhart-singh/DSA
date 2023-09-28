package Recursion;

import java.util.Arrays;

public class PartitionKEqualSubsetSum {

    private boolean dfs(int[] nums, int index, int sum, int k, int target, boolean[] visited) {
        if (k == 0)
            return true;
        if (sum == target) {
            return dfs(nums, nums.length - 1, 0, k - 1, target, visited);
        }
        if (index < 0)
            return false;

        boolean res = false;
        if (sum + nums[index] <= target && !visited[index]) {
            visited[index] = true;
            res = res || dfs(nums, index - 1, sum + nums[index], k, target, visited);
            visited[index] = false;
        }
        res = res || dfs(nums, index - 1, sum, k, target, visited);

        return res;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;

        boolean[] visited = new boolean[nums.length];

        // Sorting : so that 'sum > target' : invalid condition (base case) is reached
        // early
        Arrays.sort(nums);

        // Starting from the end : reversing an array is a hassle
        return dfs(nums, nums.length - 1, 0, k, sum / k, visited);
    }
}