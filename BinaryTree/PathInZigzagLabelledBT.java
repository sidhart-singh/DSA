package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBT {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();

        // finding the max and min value at current level
        // max_value = 2 ** level - 1
        // min_value = 2 ** (level - 1)
        int levelMax = (int) Math.pow(2, (int) (Math.log(label) / Math.log(2) + 1)) - 1;
        int levelMin = (int) Math.pow(2, (int) (Math.log(label) / Math.log(2) + 1) - 1);
        // System.out.println(levelMax + " " + levelMin);

        while (label > 0) {
            result.add(0, label);

            // update label
            // parent of current label in inverted BT
            label = (levelMax - label + levelMin) / 2;

            // update levelMax
            levelMax = levelMin - 1;

            // update levelMin
            levelMin = levelMin / 2;
        }

        System.out.println(result);
        return result;
    }
}
