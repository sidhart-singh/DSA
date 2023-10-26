package Backtracking;

public class CheckValidPartition2396 {
    // Recursion - Brute Force
    private boolean dfs(int[] nums, int index) {
        if (index == nums.length)
            return true;

        boolean res = false;
        if (index + 1 < nums.length && nums[index] == nums[index + 1])
            res = dfs(nums, index + 2);
        if (index + 2 < nums.length &&
                nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2])
            res = res || dfs(nums, index + 3);
        if (index + 2 < nums.length &&
                nums[index] + 1 == nums[index + 1] && nums[index + 1] == nums[index + 2] - 1)
            res = res || dfs(nums, index + 3);

        return res;
    }

    // Memoization - TLE
    private boolean dfs1(int[] nums, int index, Boolean[] dp) {
        if (index == nums.length)
            return true;
        if (dp[index] != null)
            return dp[index];

        boolean res = false;
        if (index + 1 < nums.length && nums[index] == nums[index + 1])
            res = dfs1(nums, index + 2, dp);
        /*
         * Seperate Calls
         * if (index + 2 < nums.length &&
         * nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2])
         * res = res || dfs1(nums, index + 3, dp);
         * if (index + 2 < nums.length &&
         * nums[index] + 1 == nums[index + 1] && nums[index + 1] == nums[index + 2] - 1)
         * res = res || dfs1(nums, index + 3, dp);
         */
        // Merge conditions
        if (index + 2 < nums.length &&
                (nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2] ||
                        nums[index] + 1 == nums[index + 1] && nums[index + 1] == nums[index + 2] - 1))
            res = res || dfs1(nums, index + 3, dp);

        dp[index] = res;
        return res;
    }

    public boolean validPartition(int[] nums) {
        // brute force
        // return dfs(nums, 0);

        // memoization
        // must use Wrapper (Boolean[]) not Primitive (boolean[])
        Boolean[] dp = new Boolean[nums.length + 1];
        return dfs1(nums, 0, dp);

        // TODO: bottom-up dp

    }
}
