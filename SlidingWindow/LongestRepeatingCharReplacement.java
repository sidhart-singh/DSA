package SlidingWindow;

import java.util.*;

public class LongestRepeatingCharReplacement {

    String input = "abab";
    int k = 2;

    public void bruteForce() {

    }

    public int slidingWindow() {

        int start = 0;
        int end = 0;

        // String -> Integer :
        // EntrySet works only with String
        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0; // count of most frequent character in the window
        int maxLength = 0; // length of longest substring

        while (end < input.length()) {

            // calculation for j-th character
            String charAtEnd = String.valueOf(input.charAt(end));
            if (!map.containsKey(charAtEnd)) {
                map.put(charAtEnd, 1);
            } else {
                map.put(charAtEnd, map.get(charAtEnd) + 1);
            }
            maxCount = Math.max(maxCount, map.get(charAtEnd));

            // condition valid : (window size - maxCount <= K) :
            // calculate temporary answer :
            if (((end - start + 1) - maxCount) <= k) {
                maxLength = Math.max(maxLength, (end - start + 1));
            }
            // condtion invalid :
            // Slide Window
            else {
                // remove calculation for i-th char
                map.put(String.valueOf(input.charAt(start)), map.get(String.valueOf(input.charAt(start))) - 1);

                // increment i and j
                start++;
            }

            end++;
        }

        return maxLength;
    }
}
