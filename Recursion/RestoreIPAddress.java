package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    private void dfs(StringBuilder s, int index, int depth, List<String> res) {
        if (depth == 4) {
            if (index == s.length())
                res.add(s.substring(0, s.length() - 1));
            return;
        }

        for (int i = index + 1; i < index + 4 && i <= s.length(); i++) {
            s.insert(i, ".");

            int doti = s.lastIndexOf(".", i - 1);
            if (Integer.parseInt(s.substring(doti + 1, i)) < 256 &&
                    ((index + 1 == i) || (s.charAt(index) != '0'))) {
                dfs(s, i + 1, depth + 1, res);
            }

            s.deleteCharAt(i);
        }

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        dfs(sb, 0, 0, res);

        System.out.println(res);
        return res;
    }
}
