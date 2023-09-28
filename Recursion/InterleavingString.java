package Recursion;

public class InterleavingString {
    private boolean dfs(String s1, String s2, String s3, int index, int i1, int i2, int d1, int d2) {
        if (index == s3.length()) {
            if (Math.abs(d1 - d2) <= 1)
                return true;
            return false;
        }

        

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1, s2, s3, 0, 0, 0, 0, 0);
    }
}
