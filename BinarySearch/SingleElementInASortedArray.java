package BinarySearch;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if((mid - 1 < 0 || nums[mid] != nums[mid - 1]) &&
                    (mid + 1 > nums.length - 1 || nums[mid] != nums[mid + 1])){
                        return nums[mid];
            
            // if nums[mid] == nums[mid - 1] and length of the left subarray(0:mid-1) is odd
            } else if (mid + 1 < nums.length || nums[mid] == nums[mid + 1] && 
                    (mid - 1)%2 != 0){
                right = mid - 2;
            } else {
                left = mid + 1;
            }

        }

        return 0;
    }
}
