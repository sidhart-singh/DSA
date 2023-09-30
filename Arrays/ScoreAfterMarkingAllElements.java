package Arrays;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ScoreAfterMarkingAllElements {
    public long findScore(int[] nums) {
        long res = 0;
        // {value : index}
        Map<Integer, Set<Integer>> heap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++)
            heap.computeIfAbsent(nums[i], k -> new TreeSet<>()).add(i);

        for (Map.Entry<Integer, Set<Integer>> e : heap.entrySet()) {
            Set<Integer> s = e.getValue();
            for (int i : s) {
                if (nums[i] != -1) {
                    res += e.getKey();
                    // mark current element
                    nums[i] = -1;

                    // mark adjacent elements
                    if (i - 1 >= 0 && i - 1 < nums.length)
                        nums[i - 1] = -1;
                    if (i + 1 >= 0 && i + 1 < nums.length)
                        nums[i + 1] = -1;
                }
            }
        }

        System.out.println(res);
        return res;
    }
}
