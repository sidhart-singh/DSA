package TwoPointers;

public class SquaresOfSortedArray {

    int nums[] = { -1 };

    public int[] twoPointers(){

        int[] result = new int[nums.length];

        int pos = 0;
        int neg = 0;
        int res_index = 0;

        // while(pos < nums.length)
        //     if(nums[pos] < 0)
        //         pos+=1;
        //     else 
        //         break;
        while( pos < nums.length && nums[pos] < 0)
            pos++;
        neg = pos - 1;

        while (res_index < nums.length){
            if(neg < 0){
                while(pos < nums.length) {
                    result[res_index++] = nums[pos] * nums[pos];
                    pos++;
                }
                break;
            }
            if(pos >= nums.length){
                while(neg >= 0) {
                    result[res_index++] = nums[neg] * nums[neg];
                    neg--;
                }
                break;
            }

            if(nums[pos] * nums[pos] <= nums[neg] * nums[neg]){
                result[res_index++] = nums[pos] * nums[pos];
                pos++;
            } else {
                result[res_index++] = nums[neg] * nums[neg];
                neg--;
            }
        }

        return result;
    }

    public int[] twoPointersII(){

        int[] result = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;
        int res_index = nums.length - 1;

        /*
         * looking for the greatest square of the starting element and last element
         * and placing the greater from the end of the result array
         */
        while (start <= end){
            if(nums[start] * nums[start] > nums[end] * nums[end]){
                result[res_index--] = nums[start] * nums[start];
                start++;
            }else{
                result[res_index--] = nums[end] * nums[end];
                end--;
            }
        }

        return result;
    }
    
}
