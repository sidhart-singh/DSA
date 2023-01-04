package BinarySearch;

public class FirstAndLastIndex {

    int nums[] = {2, 2};
    int target = 2;

    public int[] searchRange(){

        int firstIndex = -1;
        int lastIndex = -1;
        
        int low = 0;
        int high = nums.length - 1;
        // FirstIndex
        while(low <= high){ 
            int mid = low + ((high - low) >> 1);

            if(nums[mid] == target){
                firstIndex = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
                
        }

        low = 0;
        high = nums.length - 1;
        // LastIndex
        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(nums[mid] == target){
                lastIndex = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else 
                high = mid - 1;
        }

        return new int[] {firstIndex, lastIndex};
    }
}