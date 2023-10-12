package String;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinTimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> tot = new HashMap<>();
        Map<Character, Integer> li = new HashMap<>();
        int res = 0;
        for (int i = 0; i < garbage.length; i++) {
            boolean m = false;
            boolean p = false;
            boolean g = false;
            // find last index of each type of garbage
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M' && !m)
                    li.put('M', i);
                if (c == 'P' && !p)
                    li.put('P', i);
                if (c == 'G' && !g)
                    li.put('G', i);
            }
            // find total count of each type of garbage
            for (char c : garbage[i].toCharArray()) {
                tot.put(c, tot.getOrDefault(c, 0) + 1);
            }
        }

        // System.out.println(tot);
        // System.out.println(li);

        for (char c : List.of('M', 'P', 'G')) {
            if (li.containsKey(c)) {
                for (int i = 0; i < li.get(c); i++)
                    res += travel[i];
            }
            res += tot.getOrDefault(c, 0);
        }
        System.out.println(res);

        return res;
    }

    public int garbageCollectionOptimal(String[] garbage, int[] travel) {
        Map<Character, Integer> li = new HashMap<>();
        int res = 0;
        for (int i = 0; i < garbage.length; i++) {
            boolean m = false;
            boolean p = false;
            boolean g = false;
            // find last index of each type of garbage
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M' && !m)
                    li.put('M', i);
                if (c == 'P' && !p)
                    li.put('P', i);
                if (c == 'G' && !g)
                    li.put('G', i);
            }
        }
        // System.out.println(li);

        for (char c : List.of('M', 'P', 'G')) {
            if (li.containsKey(c)) {
                for (int i = 0; i < li.get(c); i++)
                    res += travel[i];
            }
        }
        for (String s : garbage)
            res += s.length();
        System.out.println(res);

        return res;
    }
}
