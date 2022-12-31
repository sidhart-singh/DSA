package SlidingWindow;

public class MinimumSizeSubarraySum {

    int[] nums = { 2,3,1,2,4,3 };
    int target = 7;

    public int bruteForce(){



        return 0;

    }

    public int slidingWindow(){

        int i = 0;
        int j = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(j < nums.length){

            // calculation for j-th element
            sum += nums[j];

            // condition / window -> valid
            while(sum >= target){
                // calculate temporary answer
                minLength = Math.min(minLength, (j - i + 1));

                // remove calculation for i-th element
                sum -= nums[i];
                // increment i
                i++;
            }

            // condition /window -> invalid 
            // increment j
            j++;

        }

        // Edge Case :
        // No subarray found that meets the target :
        // return 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
        
    }
    
}
