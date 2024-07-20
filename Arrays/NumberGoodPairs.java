package Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberGoodPairs {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long res = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % k == 0) {
                for (int j = 1; j <= Math.sqrt(nums1[i] / k); j++) {
                    if ((nums1[i] / k) % j == 0 && map.containsKey(j)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
