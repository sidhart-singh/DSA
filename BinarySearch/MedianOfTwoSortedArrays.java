package BinarySearch;

public class MedianOfTwoSortedArrays {
    
    int[] nums1 = {  };
    int[] nums2 = { 1 };

    public double binarySearch(){

        if(nums1.length > nums2.length){
            int[] nums3 = nums2;
            nums2 = nums1;
            nums1 = nums3;
        }

        int half = (nums1.length + nums2.length) / 2;

        int low = 0;
        int high = nums1.length - 1;

        // not using : ( low <= high )
        while (true) {
            int mid = low + ((high - low) >> 1);        // mid is included in left partiton
            int bPartitionIndex = half - (mid + 1) - 1; // bPartitionIndex is included in left Partition

            // Initialization
            int nums1_l = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
            int nums1_r = (mid + 1 < nums1.length) ? nums1[mid + 1] : Integer.MAX_VALUE;
            int nums2_l = (bPartitionIndex >= 0) ? nums2[bPartitionIndex] : Integer.MIN_VALUE;
            int nums2_r = (bPartitionIndex + 1 < nums2.length) ? nums2[bPartitionIndex + 1] : Integer.MAX_VALUE;

            if(nums1_l <= nums2_r && nums2_l <= nums1_r){
                
                if((nums1.length + nums2.length) % 2 == 0){
                    return (Math.max(nums1_l, nums2_l) + 
                                    Math.min(nums1_r, nums2_r)) / 2.0;
                } else {
                    return Math.min(nums1_r, nums2_r);
                }
            } else if(nums1_l > nums2_r){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        /*  Unreachable :
         * when using : while(true)
        */
        // return -1.0;
    }


}
