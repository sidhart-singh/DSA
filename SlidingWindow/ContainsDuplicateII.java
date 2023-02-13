package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();

        int L = 0;
        for(int R = 0; R < nums.length; R++){
            // Window invalid :
            // Window size greater than (K + 1)
            // valid condition : abs(R - L) <= K
            if( (R - L) > k ){
                // remove computation for L
                set.remove(nums[L]);
                // increment L
                L++;
            }
            if(set.contains(nums[R]))
                return true;

            set.add(nums[R]);

        }

        return false;
    }

    public boolean containsNearbyDuplicateBest(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) {
                m.put(nums[i], i);
            } else {
                if (Math.abs(m.get(nums[i]) - i) <= k) return true;
                m.put(nums[i], i);
            }
        }

        return false;
    }
}
