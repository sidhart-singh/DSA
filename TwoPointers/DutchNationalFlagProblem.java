package TwoPointers;

public class DutchNationalFlagProblem {

    int nums[] = { 2,0,1 };

    public int[] sortColors(){

        /*
         * low and high which are pointing to the first and the last element of the numsay respectively.
         *  So while iterating, we will move all 0s before low and all 2s after high so that in the end,
         *  all 1s will be between low and high
         */

        int low = 0;
        int high = nums.length - 1;

        int i = 0;
        while(i <= high){
            int temp;
            if(nums[i] == 0){
                // swap with nums[low] : increment low
                temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;

                i++;
                low++;
            }
            else if(nums[i] == 1){
                // inrement i
                i++;
            }
            else {
                // swap with nums[high] : decrement high
                temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;

                high--;
            }

            // i not incremented each iteration :
            // only if nums[i] == 1 : 
            //      we keep swapping nums[i] until nums[i] == 1 : increment i
            // and nums[i] == 0 :
            //      nums[i] has the correct element
        }

        return nums;


        // while(i <= high) {
        //     if(nums[i] == 0) {
        //       //swap
        //       //[nums[i], nums[low]] = [nums[low], nums[i]]
        //       int temp = nums[i];
        //       nums[i] = nums[low];
        //       nums[low] = temp;
        //       //increment i and low
        //       i++;
        //       low++;
        //     } else if(nums[i] == 1){
        //       i++;
        //     } else{
        //       //the case for nums[i] === 2
        //       //swap
        //       // [nums[i], nums[high]] = [nums[high], nums[i]]
        //       int temp = nums[i];
        //       nums[i] = nums[high];
        //       nums[high] = temp;
        //       //decrement high only, after the swap the number
        //       //at index i could be 0, 1, or 2
        //       high--;
        //     }
        //   }
        //   return nums;
    }
}