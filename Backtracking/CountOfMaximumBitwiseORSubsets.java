package Backtracking;

public class CountOfMaximumBitwiseORSubsets {
    // RETURNING dfs
    private int dfs(int[] nums, int index, int max, int cor) {
        if (index == nums.length) {
            if (cor == max)
                return 1;
            return 0;
        }

        return dfs(nums, index + 1, max, cor | nums[index])
                + dfs(nums, index + 1, max, cor);
    }

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums)
            max |= n;

        return dfs(nums, 0, max, 0);
    }

    // VOID dfs
    // private void dfs(int[] nums, int index, int max, int cor, int[] res) {
    // if (index == nums.length) {
    // if (cor == max)
    // res[0]++;
    // return;
    // }

    // dfs(nums, index + 1, max, cor | nums[index], res);
    // dfs(nums, index + 1, max, cor, res);
    // }

    // public int countMaxOrSubsets(int[] nums) {
    // int[] res = new int[1];
    // int max = 0;
    // for (int n : nums)
    // max |= n;
    // dfs(nums, 0, max, 0, res);

    // return res[0];
    // }

}
