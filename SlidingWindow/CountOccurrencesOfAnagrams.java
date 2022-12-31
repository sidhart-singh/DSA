package SlidingWindow;

import java.util.*;

public class CountOccurrencesOfAnagrams {

    static String mainString = "cbaebabacd";
    static String subString = "abc";

    /*
     * "cbaebabacd"
     * "abc"
     */

    public void bruteForce() {

        var subStringPerm = new ArrayList<String>();
        var tempList = new ArrayList<String>();

        for (int i = 0; i < subString.length(); i++) {
            for (int j = i; j < subString.length(); j++) {
                String temp = "";
                for (int k = i; k <= j; k++) {
                    // System.out.print(subString.toCharArray()[k]);
                    temp += subString.toCharArray()[k];
                }
                subStringPerm.add(temp);
                // System.out.print(" ");

                if (j - i + 1 == subString.length())
                    tempList.add(subString.substring(i, j + 1));
            }
            // System.out.println();
        }

        for (var s : tempList)
            System.out.print(s + " ");

        for (var perm : subStringPerm) {
            // if (mainString.contains(perm))
            System.out.print(perm + " ");
        }

    }

    public void slidingWindow() {

        int k = subString.length(); // Window Size
        int i = 0; // Start Index
        int j = 0; // End Index

        char[] charArray = mainString.toCharArray();
        var map = new HashMap<Character, Integer>();

        // creating map of subString
        for (var c : subString.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int countOfKeys = map.size(); // count of keys with value greater than 0
        int countOfAnagrams = 0; // count of anagrams : result

        List<Integer> indexOfAnagrams = new ArrayList<>();

        while (j < mainString.length()) {

            // Calculation for j-th element :
            // decrement count of char at j , if its present in map
            if (map.containsKey(charArray[j])) {
                map.put(charArray[j], map.get(charArray[j]) - 1);

                // decrement 'count' if value of char at j is equal to 0
                if (map.get(charArray[j]) == 0) {
                    countOfKeys = countOfKeys - 1;
                }
            }

            if ((j - i + 1) < k) {
                // increment j
                j++;
            } else if ((j - i + 1) == k) {
                // 1. calculate temp answer
                if (countOfKeys == 0) {
                    countOfAnagrams++;
                    indexOfAnagrams.add(i);
                }

                // 2. Slide window
                // remove calculation for char at i
                if (map.containsKey(charArray[i])) {
                    map.put(charArray[i], map.get(charArray[i]) + 1);

                    if (map.get(charArray[i]) != 0) {
                        countOfKeys = countOfKeys + 1;
                    }
                }

                // increment i and j
                i++;
                j++;
            }

        }

        System.out.println("Count of Anagrams: " + countOfAnagrams + "Inidices List: " + indexOfAnagrams);
    }

}