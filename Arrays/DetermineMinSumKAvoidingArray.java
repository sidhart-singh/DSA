package Arrays;

import java.util.HashSet;
import java.util.Set;

public class DetermineMinSumKAvoidingArray {
    // TODO : Optimize
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 1; set.size() < n; i++) {
            if (!set.contains(k - i)) {
                System.out.println(i);
                set.add(i);
                res += i;
            }
        }
        System.out.println(res);
        return res;
    }
}