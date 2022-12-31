package SlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    String mainString = "pwwkew";

    public int bruteForce() {

        // int start = 0;
        // int end = 0;

        // Set<Character> set = new HashSet<Character>();

        // while (end < mainString.length()) {
        // set.add(mainString.charAt(end));
        // }

        return 0;
    }

    // String Implementation
    public int slidingWindow_I() {

        int start = 0;
        int end = 0;

        // Set<Character> set = new HashSet<Character>();
        String subString = "";
        char charAtEnd;

        int maxLength = 0;

        while (end < mainString.length()) {

            // calculation for j-th character
            charAtEnd = mainString.charAt(end);
            // subString += charAtEnd;

            if (!subString.contains(String.valueOf(charAtEnd))) {
                subString += charAtEnd;
                // length++;

                // increment j : until condition for temp answer is not met :
                // j-th char already present in subtring
                end++;
            }

            // Slide the window : j-th char already present in the substring
            else if (subString.contains(String.valueOf(charAtEnd))) {
                // calculate temp answer : max length of substring
                System.out.println(subString);
                maxLength = Math.max(maxLength, subString.length());

                // remove calculation for i-th char :
                // increment i until substring contains j-th char
                while (subString.contains(String.valueOf(charAtEnd))) {
                    subString = subString.substring(1);
                    start = start + 1;
                }

                // increment j
                subString += charAtEnd;
                end++;

            }

        }
        // System.out.println(maxLength);
        // mainString contains all distinct chars
        return Math.max(subString.length(), maxLength);
    }

    // Hashset Implementation
    public int slidingWindow_II() {

        int start = 0;
        int end = 0;

        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        while (end < mainString.length()) {

            // calculation for j-th element/character
            // j-th element present in set
            if (!set.contains(mainString.charAt(end))) {
                set.add(mainString.charAt(end));
            }
            // j-th element not present in set
            else {
                while (set.contains(mainString.charAt(end))) {
                    // remove calculation for char at i
                    set.remove(mainString.charAt(start));
                    // increment i
                    start++;
                }
                set.add(mainString.charAt(end));
            }

            // (Window size < K) / (Condition -> False)
            // ---- Each length can be a valid answer

            // 1. Calculate answer
            maxLength = Math.max(maxLength, end - start + 1);

            // 2. Slide Window

            // ---- increment j
            end++;

        }

        return maxLength;
    }

    /*
     * above code can be further simplified :
     * Using a HashSet
     */

    public int slidingWindow_III() {

        int start = 0;
        int end = 0;

        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        while (end < mainString.length()) {

            // calculation for j-th element/character
            // j-th element not present in set
            /*
             * if (!set.contains(mainString.charAt(end))) {
             * set.add(mainString.charAt(end));
             * }
             */
            // j-th element present in set
            if (set.contains(mainString.charAt(end))) {
                while (set.contains(mainString.charAt(end))) {
                    // remove calculation for char at i
                    set.remove(mainString.charAt(start));
                    // increment i
                    start++;
                }
                // set.add(mainString.charAt(end));
            }

            /*
             * Simplification :
             * 'calclation for j-th char' section
             * contained set.add() both in if and else section :
             * 
             * Removed If
             * Changes else to if
             * set.add() after if
             */
            set.add(mainString.charAt(end));

            // (Window size < K) / (Condition -> False)
            // ---- Each length can be a valid answer

            // (Condition -> True)
            // 1. Calculate answer
            maxLength = Math.max(maxLength, end - start + 1);

            // 2. Slide Window

            // ---- increment j
            end++;

        }

        return maxLength;
    }

}
