package BinarySearch;

public class FindMinimumSortedRotatedII {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){

            int mid = low + ((high - low) >> 1);

            if(nums[mid] > nums[high]){
                // mid is a possible answer
                low = mid + 1;
            } else if(nums[mid] < nums[high]){
                high = mid;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
