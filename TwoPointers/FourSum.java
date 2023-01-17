package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    
    int[] nums = { 1000000000,1000000000,1000000000,1000000000 };
    int target = -294967296;

    public List<List<Integer>> fourSum(){

        if(nums == null || nums.length == 0)        // empty list
            return null;

        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){

                int left = j + 1; 
                int right = nums.length - 1;
                int iPlusJ = nums[i] + nums[j];

                while(left < right){
                    long sum = (long)nums[left] + nums[right] + iPlusJ;     // overflow
                    if(sum == target){
                        result.add(Arrays.asList(nums[left], nums[right], nums[i], nums[j]));

                        int l = nums[left];
                        while(left < nums.length && nums[left] == l) ++left;

                        int r = nums[right];
                        while(right > 0 && nums[right] == r) --right;
                    } 
                    else if(sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }

                }

                while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;

            }

            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }
}
