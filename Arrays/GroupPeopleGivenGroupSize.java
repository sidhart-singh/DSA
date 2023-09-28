package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPeopleGivenGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Optimal Code
        HashMap<Integer, List<Integer>> temp_group = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            temp_group.putIfAbsent(size, new ArrayList<>());
            temp_group.get(size).add(i);

            if (temp_group.get(size).size() == size) {
                result.add(new ArrayList<>(temp_group.get(size)));
                temp_group.get(size).clear();
            }
        }
        return result;

        // Naive Code
        // List<List<Integer>> res = new ArrayList<>();
        // Map<Integer, List<List<Integer>>> map = new HashMap<>();

        // for (int i = 0; i < groupSizes.length; i++) {
        // // Not working when using refernce 'list' for 'map.get(groupSizes[i])'
        // // List<List<Integer>> list = map.get(groupSizes[i]);
        // if (map.containsKey(groupSizes[i])) {
        // if (map.get(groupSizes[i]).get(map.get(groupSizes[i]).size() - 1).size() ==
        // groupSizes[i]) {
        // map.get(groupSizes[i]).add(new ArrayList<>());
        // map.get(groupSizes[i]).get(map.get(groupSizes[i]).size() - 1).add(i);
        // } else {
        // map.get(groupSizes[i]).get(map.get(groupSizes[i]).size() - 1).add(i);
        // }
        // } else {
        // map.put(groupSizes[i], new ArrayList<>());
        // map.get(groupSizes[i]).add(new ArrayList<>());
        // map.get(groupSizes[i]).get(map.get(groupSizes[i]).size() - 1).add(i);
        // }
        // }

        // for (Map.Entry<Integer, List<List<Integer>>> e : map.entrySet()) {
        // for (var l : e.getValue()) {
        // res.add(l);
        // }
        // }

        // System.out.println(res);
        // return res;

    }
}