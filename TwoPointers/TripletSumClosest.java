package TwoPointers;

import java.util.*;

public class TripletSumClosest {
    
    int nums[] = { -1, 2, 1, -4 };
    int targetSum = 1;

    public int tripletSumCloseToTarget(){
        Arrays.sort(nums);
        
        int smallestDifference = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length - 2; i++) {
          int start = i + 1;
          int end = nums.length - 1;
          
          while(start < end) {
            int targetDifference = targetSum - nums[i] - nums[start] - nums[end];
            
            if(targetDifference == 0) {
              //we've found a triplet with an exact sum
              //so return the sum of all the numbers
              return targetSum - targetDifference;
            }
            
            if(Math.abs(targetDifference) < Math.abs(smallestDifference)) {
              //save the closet difference
              smallestDifference = targetDifference;
            }
            //the second part of the followinf 'if' is to handle the smallest sum
            //when we have more than one solution
            if(Math.abs(targetDifference) < Math.abs(smallestDifference) || (Math.abs(targetDifference) == Math.abs(smallestDifference) && targetDifference > smallestDifference)) {
              //save the closest and the biggest difference
              smallestDifference = targetDifference;
            }
            
            if(targetDifference > 0) {
              //we need a triplet with a bigger sum
              start++;
            } else {
              //we need a triplet with a smaller sum
              end--;
            }
          }
        }
        return targetSum - smallestDifference;
      }
      

}
