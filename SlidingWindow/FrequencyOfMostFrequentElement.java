package SlidingWindow;

import java.util.*;

public class FrequencyOfMostFrequentElement{

    int[] nums = { 5, 5, 3, 1, 2 };
    int k = 3;

    public boolean bruteForce(){



        return false;
    }

    public int slidingWindow(){

        // Sort the array
        Arrays.sort(nums);

        int maxLength = 0;
        long sum = 0;       // 1 <= nums[i] <= 10^5
        int i = 0;
        int j = 0;

        while(j< nums.length){

            // calculation for j-th element
            sum += nums[j];

            // condition -> invalid
            while((long)nums[j] * (j-i+1) > sum+k ){
                
                // remove i-th element while condition is valid
                sum -= nums[i];
                
                // increment i
                i++;
                
            }

            // condition -> valid
            // calculate temporary answer
            maxLength = Math.max(maxLength, (j - i + 1));

            // increment j
            j++;

        }

        return maxLength;
    }

}