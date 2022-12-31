package SlidingWindow;

import java.util.*;

public class SubarrayProductLessThanK {
    
    int nums[] = { 10,5,2,6 };
    int k = 100;

    public int numSubarrayProsuctLessThanK(){

        Arrays.sort(nums);

        int count = 0;

        int product = 1;
        int i = 0;
        int j = 0;

        while( j < nums.length ){
            // calculation for j-th element
            product *= nums[j];

            // window size -> invalid :
            while(i <= j && product >= k){
                // remove calculation for i-th element
                product /= nums[i];

                // shrink window
                i++;
            }

            // window size -> valid
            if(product < k){
                // calculate temporary answer
                count += j-i+1;
            } 

            // increment window size
            j++;
        }

        return count;

    }
}
