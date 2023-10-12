package Recursion;

public class PunishmentNumber {
    // private boolean dfs_1(int o, int n, int index, int sum) {
    // without passing string for the number
    // }

    private boolean dfs(int o, StringBuilder n, int index, int sum) {
        if (index == n.length()) {
            if (sum == o)
                return true;
            return false;
        }

        for (int i = 1; i < n.length() - index + 1; i++) {
            int c = Integer.parseInt(n.substring(index, index + i));
            sum += c;
            if (dfs(o, n, index + i, sum))
                return true;
            sum -= c;
        }

        return false;
    }

    public int punishmentNumber(int n) {
        int res = 0;
        StringBuilder s;
        for (int i = 1; i <= n; i++) {
            int c = i * i;
            s = new StringBuilder(String.valueOf(c));
            if (dfs(i, s, 0, 0)) {
                res += c;
                System.out.println(s.toString() + " " + res);
            }
        }

        return res;
    }
}