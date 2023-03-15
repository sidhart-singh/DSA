package Arrays;

public class RemoveDupliacteSortedArrayII {
    public int removeDuplicates(int[] nums) {
        
        int l = 0;      // index till which the array is organised/correct
        int r = 0;      

        while( r < nums.length ) {

            // check if count of the current element is valid :
            // count the frequency of the element
            int count = 1;
            while( r+1 < nums.length && nums[r] == nums[r + 1]){
                r++;
                count++;
            }

            // shift the valid number of current element to the correct index('l')

            // number of elements to be shifted :
            // maximum = 2 and min = count
            for(int i = 0; i < Math.min(2, count); i++){
                // shift the element at 'r' to 'l'
                nums[l] = nums[r];
                l++;
            }
            r++;

        }

        return l;
    }
}
