package TwoHeaps;

public class Test {
    int lcs(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return max(lcs(X, Y, m, n - 1),
                    lcs(X, Y, m - 1, n));
    }

    int longest_subsequence(String X, String Y) {
        int res = -1;
        res = lcs(X, Y, X.length(), Y.length());
        return res;
    }

    // Utility function to get max of 2 integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

}
