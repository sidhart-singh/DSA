package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public void dfs(List<List<Integer>> result, int n, int k, int ele, int index) {
        if (index <= n)
            result.add(new ArrayList<>());

        // base
        if (result.get(index) != null && result.get(index).size() == k)
            return;

        for (int i = ele; i <= n; i++) {
            // node
            // change : add
            if (result.get(index) != null)
                result.get(index).add(i);

            // children
            dfs(result, n, k, i + 1, index + 1);

            // undo change : remove
            result.get(index).remove(Integer.valueOf(i));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // List<Integer> subList = new ArrayList<>();

        dfs(result, n, k, 1, 0);
        System.out.println(result);

        return result;
    }
}
