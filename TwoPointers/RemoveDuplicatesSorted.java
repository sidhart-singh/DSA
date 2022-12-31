package TwoPointers;

// import java.util.Arrays;

public class RemoveDuplicatesSorted {

    int nums[] = { 0,0,1,1,1,2,2,3,3,4 };

    public int twoPointers() {

        int slow = 1;   // next non duplicate
        int fast = 1;   // iterating

        while(fast < nums.length){
            /*
             * Since, array is sorted 
             * element at 'slow' will be equal or greater than 'fast' 
             * not smaller than the element at 'slow' or
             * equal to any element before 'slow'
             */
            if(nums[slow - 1] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }
        
        // System.out.println(Arrays.toString(nums));

        return slow;
    }

}