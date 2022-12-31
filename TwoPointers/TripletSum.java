package TwoPointers;

import java.util.*;

public class TripletSum {
    
    int nums[] = { -3, 0, 1, 2, -1, 1, -2 };

    public List<List<Integer>> searchTriplet(){
        // Sort the array
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            //skip the same element to avoid dupes
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            searchPairs(nums, -nums[i], i + 1, triplets);
        }

        return triplets;

    }

    public void searchPairs(int[] nums, int target, int start, List<List<Integer>> triplets){

        int i = start;
        int j = nums.length - 1;
        int currentSum = 0;

        while(i < j){
            currentSum = nums[i] + nums[j];

            if(currentSum == target){
                triplets.add(Arrays.asList(-target, nums[i], nums[j]));

                i++;
                j--;

                while(i < j && nums[i] == nums[i-1]){
                    i++;
                }
                while(i < j && nums[j] == nums[j+1]){
                    j--;
                }

            } else if(target > currentSum){
                i++;
            } else {
                j--;
            }

        }

    }

}
