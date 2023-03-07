package BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {

        if(nums.length == 1)
            return 0;

        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int mid = l + ((r - l) >> 1);

            // nums.length '- 1' :
            // excluding both the first and last element of the array
            if(mid > 0 && mid < nums.length - 1){
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                    return mid;

                // move in the direction of rising slope
                else if(nums[mid] < nums[mid - 1])
                    r = mid - 1;
                else if(nums[mid] < nums[mid + 1])
                    l = mid + 1;
            } 
            else if(mid == 0) {
                if(nums[mid] > nums[mid + 1])
                    return 0;
                // no other element towards the right is a peak 
                else 
                    return 1;
            } 
            else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1])
                    return mid;
                else
                    return mid - 1;
            }
        }

        return -1;
    }

}
