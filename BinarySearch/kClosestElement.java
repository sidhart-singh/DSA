package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class kClosestElement {

    int nums[] = {1,2,3,4,5};
    int k = 4;
    int x = -1;

    public List<Integer> findClosestElements() {
        int low = 0;
        int high = nums.length - k;

        while(low < high){
            int mid = low + ((high - low) / 2);

            if(x - nums[mid] > nums[mid + k] - x){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int[] result = Arrays.copyOfRange(nums, low, low + k);
        return Arrays.stream(result)        // IntStream
                    .boxed()                // Stream<Integer>
                    .collect(Collectors.toList());
    }

    public List<Integer> kClosestTwoPointers(){
        List<Integer> result = new ArrayList<>();

        int low = 0;
        int high = nums.length - 1;

        // low : index of the element closest to target
        while(low <= high){
            int mid = low + (high - low) >> 1;

            if(nums[mid] == x){
                low = mid;
                break;
            } else if(nums[mid] < x){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        // System.out.println(nums[low]);

        int left = low;
        int right = low;

        while(k > 0){

            if( left - 1 >= 0 && right + 1 < nums.length ){
                if((x - nums[left - 1]) > (nums[right + 1] - x)){
                    right++;
                } else {
                    left--;
                }
            } else if (left - 1 < 0)
                right++;
            else if(right + 1 >= nums.length)
                left--;

            k--;
        }

        return null;
    }
}
