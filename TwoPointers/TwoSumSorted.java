package TwoPointers;

public class TwoSumSorted {
    
    int nums[] = { 2,7,11,15 };
    int target = 9;

    // ARRAY SORTED 
    public int[] twoPointers(){

        int result[] = new int[2];

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {

            if(nums[start] + nums[end] == target){        
                result[0] = start;
                result[1] = end;
                       
                return result;
            }

            if(nums[start] + nums[end] < target){
                start++;
            } else {
                end--;
            }

        }

        return result;
        
    }

}
