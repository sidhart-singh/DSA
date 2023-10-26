package Backtracking;

import java.util.HashMap;
import java.util.List;

public class MaxLengthOfConcatStringsUniqueChars {

    private boolean isValid(String s) {
        HashMap<Character, Boolean> flag = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (flag.containsKey(c))
                return false;
            else
                flag.put(c, true);
        }

        return true;
    }

    private void dfs(List<String> arr, int index, StringBuilder subseq, int[] res) {

        if (index == arr.size()) {
            res[0] = Math.max(res[0], subseq.length());
            return;
        }

        res[0] = Math.max(res[0], subseq.length());

        for (int i = index; i < arr.size(); i++) {
            if (isValid(arr.get(i) + subseq.toString())) {
                subseq.append(arr.get(i));
                dfs(arr, i + 1, subseq, res);
                subseq.delete(subseq.length() - arr.get(i).length(), subseq.length());
            }
        }
    }

    public int maxLength(List<String> arr) {
        int[] res = { 0 };
        StringBuilder subseq;
        for (int i = 0; i < arr.size(); i++) {
            subseq = new StringBuilder(arr.get(i));
            if (isValid(arr.get(i)))
                dfs(arr, i + 1, subseq, res);
        }
        System.out.println(res[0]);
        return res[0];
    }
}
