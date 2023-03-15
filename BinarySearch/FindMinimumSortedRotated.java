package BinarySearch;

public class FindMinimumSortedRotated {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){

            if(nums[low] <= nums[high]) 
                return nums[low];

            int mid = low + ((high - low) >> 1);

            if(nums[mid] < nums[low]){
                // mid is a possible answer
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }

    public int findMinII(int[] nums) {
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
