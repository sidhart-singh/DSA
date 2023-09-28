package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    // Optimal Solution
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < count[i])
                    break;
            if (i == 26)
                res.add(a);
        }
        return res;
    }

    private int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray())
            count[c - 'a']++;
        return count;
    }

    public List<String> wordSubsets1(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        // { Character : Count }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tempMap = new HashMap<>();

        for (String word : words2) {
            tempMap.clear();

            for (int i = 0; i < word.length(); i++) {
                tempMap.put(word.charAt(i), tempMap.getOrDefault(word.charAt(i), 0) + 1);
            }
            System.out.println(word + tempMap);
            for (Map.Entry<Character, Integer> e : tempMap.entrySet()) {
                map.put(e.getKey(), Math.max(map.getOrDefault(e.getKey(), 0), e.getValue()));
            }
        }
        System.out.println("Final map: " + map);

        for (String word : words1) {
            tempMap.clear();

            for (int i = 0; i < word.length(); i++) {
                tempMap.put(word.charAt(i), tempMap.getOrDefault(word.charAt(i), 0) + 1);
            }
            System.out.println(word + tempMap);
            boolean flag = true;
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                if (!tempMap.containsKey(e.getKey()) ||
                        !(tempMap.get(e.getKey()) >= e.getValue())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                res.add(word);
        }
        System.out.println("result: " + res);
        return res;
    }
}
