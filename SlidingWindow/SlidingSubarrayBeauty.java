package SlidingWindow;

import java.util.TreeMap;

public class SlidingSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int i = 0;
        int[] result = new int[n - k + 1];

        // cannot use pq/heap : need to remove a element which might not be on the
        // front/top of pq/heap
        // using TreeMap : store elements in order
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        while (r < n) {
            // add element to map
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);

            // window invalid : < k
            if ((r - l + 1) < k) {
                // Compute for rth element : increase freq of rth element
                // increment r
                // freqMap.put(nums[r++], freqMap.getOrDefault(nums[r++], 0) + 1);
                r++;
            }
            // window valid : = k
            else if ((r - l + 1) == k) {
                // 1. calculate ans
                result[i++] = xthSmallest(x, freqMap);

                // 2. remove calc for lth element : decrement its freq
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);

                // increment l and r
                l++;
                r++;
            }

        }

        return result;
    }

    public int xthSmallest(int x, TreeMap<Integer, Integer> freqMap) {
        int smallest = 0;
        for (int n : freqMap.keySet()) {
            if (n < 0)
                smallest += freqMap.get(n);
            else
                // directly return 0 : if n < 0 :
                // the first key(smallest val in the map) being positive : rest all greater
                return 0;

            if (smallest >= x)
                return n;
        }

        return 0;
    }
}
