package Arrays;

import java.util.Arrays;

class RotateArray {
    public void reverse(int[] nums, int i, int j){

        // reveres the array
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {

        /* Rotate array in constant space */
        
        // [1] : rotate doesn't effect
        if(nums.length == 1)
            return;

        // [1,2,3,4,5] , k = 8 : [3,4,5,1,2]
        // [1, 2], k = 5 : [2, 1]
        if(k > nums.length)
            k = k % nums.length;
        
        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, nums.length - 1);
        // System.out.println(Arrays.toString(nums));

    }
}