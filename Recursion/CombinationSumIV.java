package Recursion;

import java.util.HashMap;

class CombinationSumIV {
    // TODO: Optimize to Bottom-Up DP
    private int dfs(int[] nums, int target, HashMap<Integer, Integer> dp) {
        if (dp.get(target) != -1)
            return dp.get(target);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // must only recursively call if nums[i] <= target
            if (target >= nums[i])
                res += dfs(nums, target - nums[i], dp);
        }

        dp.put(target, res);
        return dp.get(target);
    }

    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>(target + 1);

        for (int i = 0; i < target + 1; i++)
            dp.put(i, -1);
        // initialize for 0 -> 1
        dp.put(0, 1);

        System.out.println(dfs(nums, target, dp));

        return dp.get(target);
    }
}