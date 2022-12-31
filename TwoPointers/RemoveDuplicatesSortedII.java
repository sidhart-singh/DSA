package TwoPointers;

import java.util.Arrays;

public class RemoveDuplicatesSortedII {

    int nums[] = { 0,0,1,1,1,1,2,3,3 };
    // OUTPUT : 7, nums[] = { 0,0,1,1,2,3,3 };

    public int twoPointers() {

        int slow = 2;
        int fast = 2;
        while(fast < nums.length){
            
            if(nums[slow - 2] != nums[fast])
                nums[slow++] = nums[fast];

            fast++;
        }

        System.out.println(Arrays.toString(nums));
        return slow;
    }

}