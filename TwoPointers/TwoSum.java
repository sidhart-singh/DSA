package TwoPointers;

import java.util.*;

public class TwoSum {

    int nums[] = { 3,2,4 };
    int target = 6;

    public int[] twoPointers(){

        // HashMap approach : 
        // Array can be unsorted

        Map<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        while(i < nums.length){
            if(map.containsKey(target - nums[i])){
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }

            i++;
        }

        return new int[] {};
    }
    
}
