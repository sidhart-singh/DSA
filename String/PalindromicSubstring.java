package String;

public class PalindromicSubstring {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() &&
            // check characters in the while condition : not in seperate 'if' : else
            // infinite loop
                    s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() &&
            // check characters in the while condition : not in seperate 'if' : else
            // infinite loop
                    s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }

        return result;
    }
}
