package SlidingWindow;

import java.util.*;

public class PermutationOfString {
    // "abcdxabcde"
    // "abcdeabcdx"

    String s1 = "abcdxabcde";
    String s2 = "abcdeabcdx";

    public static ArrayList<String> perms = new ArrayList<>();

    public boolean bruteForce() {

        ArrayList<String> perms = recPermutation(s1, "");
        for (var perm : perms) {
            // System.out.println(perm);

            if (s2.contains(perm))
                return true;
        }

        return false;

    }

    /*
     * Time Complexity : O(n * n!)
     */
    public static ArrayList<String> recPermutation(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            perms.add(ans);
            // System.out.print(ans + " ");
            return perms;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            recPermutation(ros, ans + ch);
        }

        return perms;
    }

    public boolean slidingWindow() {

        var s2_char = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        // Intialize the hash map
        for (var c : s1.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        // int count = 0; // count of characters of the hashmap present in the window
        // for (int i = 0, j = 0, k = map.size(); j < s2_char.length; j++) {
        // char temp = s2_char[j];

        // // Condition Invalid :
        // if (map.containsKey(s2_char[j])) {
        // map.put(s2_char[j], map.get(s2_char[j]) - 1);
        // if (map.get(s2_char[j]) == 0)
        // count++;
        // }

        // // Condition Valid :
        // // calculate answer
        // if (count == map.size())
        // return true;

        // if (j - i + 1 == k) {
        // if (map.containsKey(s2_char[i])) {
        // if (map.get(s2_char[i]) == 0)
        // count--;
        // map.put(s2_char[i], map.get(s2_char[i]) + 1);
        // }
        // i++;
        // }

        // }

        int i = 0;
        int j = 0;
        int k = s1.length();
        int count = map.size();

        while (j < s2.length()) {

            // calculation for j-th char
            if (map.containsKey(s2.charAt(j))) {
                map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);

                if (map.get(s2.charAt(j)) == 0)
                    count--;
            }

            if ((j - i + 1) == k) {
                // 1. calculate answer
                if (count == 0) {
                    return true;
                }

                // 2. slide window
                // remove calculation for i-th char
                if (map.containsKey(s2_char[i])) {
                    map.put(s2_char[i], map.get(s2_char[i]) + 1);

                    if (map.get(s2_char[i]) == 1) {
                        count++;
                    }
                }

                // increment i and j
                i++;
            }

            j++;
        }

        return false;
    }

}
