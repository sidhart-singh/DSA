package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombination {

    // Optimized Code :
    private void dfs(String digits, int index, String[] map, String temp, List<String> res) {
        if (digits.length() == 0)
            return;
        if (index == digits.length()) {
            res.add(temp);
            return;
        }

        for (char c : map[Character.getNumericValue(digits.charAt(index))].toCharArray()) {
            temp = temp + c;
            dfs(digits, index + 1, map, temp, res);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String temp = "";
        String[] map = { "0", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        dfs(digits, 0, map, temp, res);

        return res;
    }

    // using maps and lists
    private void dfs(String digits, int index, List<List<Character>> map, List<Character> temp, List<String> res) {
        if (digits.length() == 0) {
            return;
        }
        if (index == digits.length()) {
            res.add(temp.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
            return;
        }

        for (char c : map.get(Character.getNumericValue(digits.charAt(index)))) {
            temp.add(c);
            dfs(digits, index + 1, map, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        List<Character> temp = new ArrayList<>();

        List<List<Character>> map = new ArrayList<>();
        map.add(List.of());
        map.add(List.of());
        map.add(List.of('a', 'b', 'c'));
        map.add(List.of('d', 'e', 'f'));
        map.add(List.of('g', 'h', 'i'));
        map.add(List.of('j', 'k', 'l'));
        map.add(List.of('m', 'n', 'o'));
        map.add(List.of('p', 'q', 'r', 's'));
        map.add(List.of('t', 'u', 'v'));
        map.add(List.of('w', 'x', 'y', 'z'));

        dfs(digits, 0, map, temp, res);
        System.out.println(res);
        return res;
    }

}
