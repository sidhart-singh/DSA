package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    // tcnt: total count of '(' open parentheses
    // ccnt: current count of '(' open parentheses
    private void dfs(int n, int tcnt, int ccnt, StringBuilder subStr, List<String> res) {
        if (subStr.length() == 2 * n) {
            res.add(new String(subStr));
            return;
        }

        if (tcnt < n && ccnt < n) {
            subStr.append("(");
            dfs(n, tcnt + 1, ccnt + 1, subStr, res);
            subStr.deleteCharAt(subStr.length() - 1);
        }
        if (tcnt > 0 && ccnt > 0) {
            subStr.append(")");
            dfs(n, tcnt, ccnt - 1, subStr, res);
            subStr.deleteCharAt(subStr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder subStr = new StringBuilder();

        dfs(n, 0, 0, subStr, res);
        System.out.println(res);
        return res;
    }
}
