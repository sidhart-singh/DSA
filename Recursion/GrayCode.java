package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {

    public List<Integer> grayCodeOptimal(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 1; i <= n; i++) {
            List<Integer> rev = new ArrayList<>(list);
            Collections.reverse(rev);
            int val = (int) Math.pow(2, i - 1);
            for (int v : rev)
                list.add(v + val);
        }

        return list;
    }

    private void dfs(int n, int index, StringBuilder s, Set<String> set) {
        if (index == n) {
            /*
             * NOTE:
             * objects are passed by reference, but when you assign a new object to a
             * reference variable, it only affects the local scope of that function.
             * Therefore, when you assign a new ArrayList to res, it doesn't affect the
             * original reference outside of the function.
             * 
             * To fix this issue, you need to modify the existing res list instead of
             * reassigning it.
             */
            // res.addAll(set);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            s.setCharAt(i, (c == '0' ? '1' : '0'));

            if (!set.contains(s.toString())) {
                set.add(s.toString());
                dfs(n, index + 1, s, set);
                // found a sequence : return
                if (set.size() == n)
                    return;
                set.remove(s.toString());
            }

            s.setCharAt(i, c);
        }

    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();
        StringBuilder s;

        s = new StringBuilder("0".repeat(n));
        set.add(s.toString());

        dfs((int) Math.pow(2, n), 1, s, set);

        for (String st : set)
            res.add(Integer.parseInt(st, 2));

        System.out.println(set);
        System.out.println(res);

        return res;
    }

}
