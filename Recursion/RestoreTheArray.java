package Recursion;

import java.util.HashMap;

public class RestoreTheArray {

    // Brute Force - recursive
    private int dfs_bf(String s, int k, int index) {
        if (index == s.length())
            return 1;
        // may put here or while checking the 'num'
        if (s.charAt(index) == '0')
            return 0;

        int res = 0;
        long num = 0;
        for (int i = index; i < s.length(); i++) {
            // using 'long res' is not required : just while parsing string to number
            // so using 'Long.parseLong()' instead of 'Integer.parseInt()'
            // O ( N )
            // if (Long.parseLong(s.substring(index, i + 1)) > k)
            // break;

            // O ( 1 ) : use a variable and append the digit as we iterate
            num = (num * 10) + s.charAt(index) - '0';
            // 'num < 1' : we don't need base case 's[index] == '0''
            if (num < 1 && num > k)
                break;
            res = res + dfs_bf(s, k, i + 1);
        }

        return res;
    }

    // memoization
    private int dfs_m(String s, int k, int index, HashMap<Integer, Integer> dp) {
        if (index == s.length())
            return 1;
        if (dp.containsKey(index))
            return dp.get(index);

        int res = 0;
        long num = 0;
        for (int i = index; i < s.length(); i++) {
            num = (num * 10) + s.charAt(index) - '0';
            if (num < 1 || num > k)
                break;
            res = (res + dfs_m(s, k, i + 1, dp)) % 1000000007;
        }
        dp.put(index, res);
        return res;
    }

    // TODO : implement 1D dp
    // int numberOfArrays(string s, int k) {
    // int n = s.size();
    // vector<int>dp(n + 1, 0);
    // //In top down
    // //1) For string starting from startIdx
    // // we needed answers of strings starting from [startIdx+1, startIdx+2, ....]
    // //2) Recursion did that for us

    // //In bottom up
    // //1) We need to pre-calculate the desired results first
    // //2) So we will go from startIdx = n - 1 to startIdx = 0
    // //3) Now for startIdx = x, we would already have answers stored for
    // // startIdx = [x+1, x+2, x+3......]

    // dp[n] = 1; //base case implemented here
    // for (int startIdx = n - 1; startIdx >= 0; startIdx--)
    // {
    // long long currNum = 0, ways = 0;
    // for (int i = startIdx; i < s.size(); i++)
    // {
    // int currDig = s[i] - '0';
    // currNum = (currNum * 10) + currDig; //building the number from L->R

    // if (currNum < 1 || currNum > k) break;
    // int nextWays = dp[i + 1];
    // ways = (ways + nextWays) % MOD;
    // }
    // dp[startIdx] = ways;
    // }
    // return dp[0];
    // }

    public int numberOfArrays(String s, int k) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int res = dfs_m(s, k, 0, dp);

        System.out.println(res);
        return res;
    }
}
