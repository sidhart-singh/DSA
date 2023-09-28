package Recursion;

import java.util.HashSet;
import java.util.Set;

// TODO: use cantos diagonal theorem
public class FindUniqueBinaryString {

    private String dfs(String[] nums, Set<String> set, StringBuilder res) {
        if (res.length() == nums.length) {
            if (!set.contains(res.toString()))
                return res.toString();
            else {
                return null;
            }
        }

        if (dfs(nums, set, res.append('0')) != null)
            return res.toString();
        res.deleteCharAt(res.length() - 1);

        if (dfs(nums, set, res.append('1')) != null)
            return res.toString();
        res.deleteCharAt(res.length() - 1);

        return null;
    }

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (String num : nums)
            set.add(num);

        return dfs(nums, set, res);

    }
}