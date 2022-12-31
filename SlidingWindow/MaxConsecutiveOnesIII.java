package SlidingWindow;

public class MaxConsecutiveOnesIII {

    int nums[] = { 1,1,1,0,0,0,1,1,1,1,0 };
    int k = 2;

    public int slidingWindow(){

        int i = 0;
        int j = 0;
        int count = 0;
        int maxLength = 0;

        while( j < nums.length ){

            // calculation for j-th element
            if(nums[j] == 0){
                count++;
            }

            // window -> valid
            // if(count <= k){
            // }
            
            // window -> invalid
            if(count > k){
                // remove calculation for i-th element
                if(nums[i] == 0)
                count--;
                
                // shrink window
                i++;
            }
            
            maxLength = Math.max(maxLength, (j-i+1));
            j++;
        }

        return maxLength;
    }
    
}
