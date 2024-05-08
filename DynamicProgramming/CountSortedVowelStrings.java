package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CountSortedVowelStrings {

    private boolean isVowel(char i) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        for (char c : vowels)
            if (c == i)
                return true;
        return false;
    }

    private int dfs(List<String> list, StringBuilder s, int n) {
        if (s.length() == n) {
            list.add(s.toString());
            return list.size();
        }

        for (char i = 'a'; i < 'z'; i++) {
            if (isVowel(i) && s.charAt(s.length() - 1) <= i) {
                s.append(i);
                dfs(list, s, n);
                s.deleteCharAt(s.length() - 1);
            }
        }

        return list.size();
    }

    public int countVowelStrings(int n) {
        int res = 0;
        String[] vowels = { "a", "e", "i", "o", "u" };
        for (String v : vowels) {
            res += dfs(new ArrayList<>(), new StringBuilder(v), n);
        }
        System.out.println(res);
        return res;
    }
}