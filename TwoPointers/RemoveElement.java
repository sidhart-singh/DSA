package TwoPointers;

import java.util.Arrays;

public class RemoveElement {

    int nums[] = { 1 };
    int k = 1;

    public int twoPointers() {
        /* 
        // FASTER - 0ms

        int first = 0;
        int last = nums.length - 1;

        for(; first <= last; first++) {
            if(nums[first] == k){
                int temp = nums[first];
                nums[first] = nums[last];
                nums[last] = temp;
                last--;
            } 
        }

        return last + 1;
        */

        int i = 0;
        int nextElement = 0;    // index of next element which is not the key

        while( i < nums.length ){
            if(nums[i] != k){
                nums[nextElement] = nums[i];
                nextElement++;
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));
        return nextElement;
    }
    
}
