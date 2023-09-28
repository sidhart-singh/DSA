package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    public void helper(List<List<Integer>> result, int[] nums, int index) {

        // base case
        if (index == nums.length) {
            // save the permutation on base reaching the end of the branch. - base
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Node
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            // recurse - children call
            helper(result, nums, index + 1);

            // unswap :
            // undo the changes before branching.
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, 0);
        System.out.println(result);

        return result;
    }
}
