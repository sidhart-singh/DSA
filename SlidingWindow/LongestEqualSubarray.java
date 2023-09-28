package SlidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Why maxF not change when decresing window 
// Lee215's explaination
// https://leetcode.com/problems/find-the-longest-equal-subarray/solutions/3934172/java-c-python-one-pass-sliding-window-o-n/
public class LongestEqualSubarray {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int maxFreq = 0;
        int l = 0;
        for (int r = 0; r < nums.size(); r++) {
            freq.put(nums.get(r), freq.getOrDefault(nums.get(r), 0) + 1);
            maxFreq = Math.max(maxFreq, nums.get(r));

            // Invalid window
            // Length of Window - maxFreq > k
            if ((r - l + 1) - maxFreq > k) {
                // delete from left of the window
                // decrement its freq
                freq.put(nums.get(l), freq.get(nums.get(l)) - 1);
                // increment the left pointer
                l++;
            }
        }

        return maxFreq;
    }
}
