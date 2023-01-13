package BinarySearch;

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
}
