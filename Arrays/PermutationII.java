package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PermutationII {
    private class Permutation {
        List<Integer> perm = new ArrayList<>();

        Permutation(List<Integer> list) {
            perm.addAll(list);
        }

        @Override
        public String toString() {
            return perm.toString();
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((perm == null) ? 0 : perm.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Permutation other = (Permutation) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (perm == null) {
                if (other.perm != null)
                    return false;
            } else if (!perm.equals(other.perm))
                return false;
            return true;
        }

        private PermutationII getEnclosingInstance() {
            return PermutationII.this;
        }

    }

    public void helper(Set<Permutation> result, int[] nums, int index) {

        // base case
        if (index == nums.length) {
            // save the permutation on base - reaching the end of the branch.
            result.add(new Permutation(Arrays.stream(nums).boxed().collect(Collectors.toList())));
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

    private void addToRes(Permutation permobj, List<List<Integer>> res) {
        res.add(permobj.perm);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Set<Permutation> resultSet = new HashSet<>();
        helper(resultSet, nums, 0);
        // System.out.println(resultSet);
        List<List<Integer>> result = new ArrayList<>();

        resultSet.stream().forEach(permObj -> addToRes(permObj, result));

        System.out.println("result: " + result);
        // for (var permObj : result)
        // result.add(permObj.perm);

        return result;
    }

    public void dfs(int n, Map<Integer, Integer> map, List<Integer> subList, List<List<Integer>> result) {
        // base
        if (subList.size() == n) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

            if (e.getValue() == 0)
                continue;
            // else ...

            // Node
            // changes
            map.put(e.getKey(), e.getValue() - 1);
            subList.add(e.getKey());

            // children
            dfs(n, map, subList, result);

            // undo changes
            map.put(e.getKey(), map.get(e.getKey()) + 1);
            subList.remove(subList.size() - 1);
        }
    }

    public List<List<Integer>> permuteUniqueII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> subList = new ArrayList<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // System.out.println(map);

        dfs(nums.length, map, subList, result);
        System.out.println(result);

        return result;
    }
}
