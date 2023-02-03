package BinaryTree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSum {

    public void maxLevelSumUtil(Node root, int level, Map<Integer, Integer> map){
        if(root == null)
            return;

        if(map.containsKey(level)){
            map.put(level, map.get(level) + root.data);
        } else {
            map.put(level, root.data);
        }

        maxLevelSumUtil(root.left, level + 1, map);
        maxLevelSumUtil(root.right, level + 1, map);
    }

    public int maxLevelSum(Node root){

        Map<Integer, Integer> map = new HashMap<>();
        maxLevelSumUtil(root, 1, map);

        Map.Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
        // return the level with max sum
        return maxEntry.getKey();
    }
}
