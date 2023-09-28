package Recursion;

public class SplittingStringIntoDescConsValues {
    private boolean dfs(String s, int index, int prev) {
        if (index == s.length())
            return true;

        for (int i = index; i < s.length(); i++) {
            int val = Integer.parseInt(s.substring(index, i + 1));
            if (prev < val)
                break;
            if (prev == val + 1 && dfs(s, i + 1, val))
                return true;
        }

        return false;
    }

    public boolean splitString(String s) {
        // "050043"
        // char[] c = s.toCharArray();
        // int l = 0;
        // int r = 5;
        // System.out.println(Integer.parseInt(String.valueOf(c, l, r - l + 1)));

        // System.out.println(Integer.parseInt(s.substring(l, r + 1)));

        for (int i = 0; i < s.length() - 1; i++) {
            int val = Integer.parseInt(s.substring(0, i + 1));
            if (dfs(s, i + 1, val))
                return true;
        }

        return false;
    }
}
