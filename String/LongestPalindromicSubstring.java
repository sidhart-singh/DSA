package String;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int[] res = { 0, 0 };
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() &&
            // check characters in the while condition : not in seperate 'if' : else
            // infinite loop
                    s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > (res[1] - res[0] + 1)) {
                    res[0] = left;
                    res[1] = right;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() &&
            // check characters in the while condition : not in seperate 'if' : else
            // infinite loop
                    s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > (res[1] - res[0] + 1)) {
                    res[0] = left;
                    res[1] = right;
                }
                left--;
                right++;
            }
        }

        return s.substring(res[0], res[1] + 1);
    }
}
