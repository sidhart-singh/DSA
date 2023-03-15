package BinarySearch;

public class SearchSortedRotatedArray {
    public int search(int[] nums, int k) {
        int low  = 0;
        int high = nums.length - 1;

        while ( low <= high ) {
            int mid = low + ((high - low) >> 2);

            if(nums[mid] == k)
                return mid;
            // Determine whether mid is in LeftSortedPortion | RightSortedPortion
            if(nums[mid] >= nums[low]) {
                // mid is in LeftSortedPortion

                // Determine whether target is in LSP | RSP
                if(k > nums[mid] || k < nums[low]){
                    // RSP
                    low = mid + 1;
                } else {
                    // LSP
                    high = mid - 1;
                }
            } else {
                // mid is in RightSortedPortion

                // Determine whether target is in LSP | RSP
                if(k < nums[mid] || k > nums[high]){
                    // LSP
                    high = mid - 1;
                } else {
                    // RSP
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
