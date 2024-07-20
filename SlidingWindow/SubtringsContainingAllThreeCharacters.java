package SlidingWindow;

import java.util.Arrays;

public class SubtringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int count[] = { 0, 0, 0 }, res = 0, i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;
    }

    // INCORRECT
    public int numberOfSubstringsWhile(String s) {
        int res = 0;
        int[] target = { 0, 0, 0 }; // flag for required characters present in the window

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == 'a' || s.charAt(right) == 'b' || s.charAt(right) == 'c') {
                target[s.charAt(right) - 'a']++;
            }

            // MAIN CONDITION : valid window
            if (Arrays.stream(target).allMatch(a -> a > 0)) {
                if (s.charAt(left) == 'a') {
                    target[0]--;
                } else if (s.charAt(left) == 'b') {
                    target[1]--;
                } else if (s.charAt(left) == 'c') {
                    target[2]--;
                }

                res++;
                left++;
                continue;
            }

            right++;
        }

        System.out.println(res);
        return res;
    }
}