package SlidingWindow;

public class SubarraySumEqualK {

    int[] nums = { 1, 1, 1 };
    int k = 2;

    // PREFIX SUM
    // SLIDING WINDOW DOESN'T WORK
    public int slidingWindow(){

        int i = 0; 
        int j = 0;

        int sum = 0;
        int result = 0;

        while ( j < nums.length ){
            sum += nums[j];

            if(sum < k)
                j++;

            if(sum == k)
                result++;

            while(sum > k){
                sum -= nums[i];
                i++;
                j++;
            }

        }

        return result;
    }
    
}
