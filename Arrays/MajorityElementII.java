package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        // max #elements with 'count > n / 3' = 2
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (map.size() == 3) {
                for (Map.Entry<Integer, Integer> e : map.entrySet())
                    map.put(e.getKey(), e.getValue() - 1);
                // Need 'iterator' for concurrent modification (remove entry)
                // 'Iterator' can only be used to 'Read' and 'Delete' in CRUD
                Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                // constant #iterations : 3 at most
                while (it.hasNext()) {
                    if (it.next().getValue() == 0)
                        it.remove();
                }
            }
            // Add in each case : not in 'else' condition
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // System.out.println(map);

        // check the count of the keys from the orignal array :
        // map may contain incorrect count
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int c = 0;
            // constant #iterations : 3 at most
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == e.getKey())
                    c++;
            }
            if (c > nums.length / 3)
                res.add(e.getKey());
        }

        return res;
    }
}
