package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequence {

    /*
     * OPTIMAL
     * 
     * public Solution() {}
     * 
     * int[] nums;
     * List<List<Integer>> globalResult;
     * int[] currentList;
     * int currentListLength;
     * 
     * public List<List<Integer>> findSubsequences(int[] nums) {
     * this.nums = nums;
     * this.currentList = new int[nums.length+1];
     * globalResult = new ArrayList<>();
     * backtrack(0, -1);
     * 
     * return globalResult;
     * }
     * 
     * public void backtrack(int i, int l ) {
     * if (i >= nums.length) {
     * if (currentListLength >= 2) {
     * var result = new ArrayList<Integer>(currentListLength);
     * for(int j = 0; j < currentListLength; j++)
     * result.add(currentList[j]);
     * globalResult.add(result);
     * }
     * return;
     * }
     * if (l == -1 || nums[i] >= nums[l]) {
     * currentList[currentListLength++] = nums[i];
     * backtrack(i+1, i);
     * currentListLength--;
     * }
     * if ((l == -1) || (nums[i] != nums[l]))
     * backtrack(i+1, l); // backtrack excluding current number
     * }
     */

    private void dfs(int[] nums, int index, List<Integer> t, Set<List<Integer>> res) {
        if (index == nums.length) {
            if (t.size() > 1)
                res.add(List.copyOf(t));
            return;
        }

        if (t.isEmpty() || nums[index] >= t.get(t.size() - 1)) {
            t.add(nums[index]);
            dfs(nums, index + 1, t, res);
            t.remove(t.get(t.size() - 1));
        }
        if (t.isEmpty() || nums[index] != t.get(t.size() - 1))
            dfs(nums, index + 1, t, res);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> t = new ArrayList<>();
        // List<Integer> t = Arrays.stream(nums)
        // .boxed()
        // .collect(Collectors.toList());

        dfs(nums, 0, t, res);
        System.out.println(res);

        return res.stream().toList();
    }
}
