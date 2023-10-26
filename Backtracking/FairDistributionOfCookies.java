package Backtracking;

public class FairDistributionOfCookies {

    private void dfs(int[] cookies, int cur, int k, int[] children, int[] res) {
        if (cur == cookies.length) {
            int max = 0;
            for (int c : children)
                max = Math.max(max, c);
            res[0] = Math.min(res[0], max);
            return;
        }
        for (int i = 0; i < k; i++) {
            children[i] += cookies[cur];
            dfs(cookies, cur + 1, k, children, res);
            children[i] -= cookies[cur];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] res = { Integer.MAX_VALUE };

        dfs(cookies, 0, k, new int[k], res);

        return res[0];
    }

}
