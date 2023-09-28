package Recursion;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    private boolean dfs(int[] nums, int index, int sum, int target, Boolean[][] dp) {
        if (index < 0) {
            if (sum == target)
                return true;
            return false;
        }
        if (dp[index][sum] != null)
            return dp[index][sum];

        boolean res = false;
        if (sum + nums[index] <= target)
            res = res || dfs(nums, index - 1, sum + nums[index], target, dp);
        res = res || dfs(nums, index - 1, sum, target, dp);

        // dp[index][sum] = dfs(nums, index + 1, sum + nums[index], target, dp) ||
        // dfs(nums, index + 1, sum, target, dp);
        dp[index][sum] = res;
        return dp[index][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[nums.length][sum + 1];

        // Sorting : so that 'sum > target' : invalid condition (base case) is reached
        // early
        Arrays.sort(nums);

        // Starting from the end : reversing an array is a hassle
        return dfs(nums, nums.length - 1, 0, sum / 2, dp);
    }

}
