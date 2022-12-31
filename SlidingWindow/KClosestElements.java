package SlidingWindow;

import java.util.*;

public class KClosestElements {
    
    // INPUTS
    int nums[] = { 1,2,3,4,5 };
    int k = 4;  
    int x = 5;

    int findCrossOver(int arr[], int low, int high, int x)
    {
        // Base cases
        if (arr[high] <= x) // x is greater than all
            return high;
        if (arr[low] > x)  // x is smaller than all
            return low;
 
        // Find the middle point
        int mid = (low + high)/2;  /* low + (high - low)/2 */
 
        /* If x is same as middle element, then return mid */
        if (arr[mid] <= x && arr[mid+1] > x)
            return mid;
 
        /* If x is greater than arr[mid], then either arr[mid + 1]
          is ceiling of x or ceiling lies in arr[mid+1...high] */
        if(arr[mid] < x)
            return findCrossOver(arr, mid+1, high, x);
 
        return findCrossOver(arr, low, mid - 1, x);
    }

    public List<Integer> slidingWindow(){

        int targetIndex = findCrossOver(nums, 0, nums.length-1, x);
        int i = 0;
        int j = 0;

        int reqElements = k;
        int iavailable = 0;
        int javailable = 0;

        // No. of elements before target index < required no. of elements
        if( targetIndex - 0 <= ( k / 2) ){               
            i = targetIndex - (targetIndex - 0);        // 0
            
            // targetIndex ( + 1 ) : for the target element
            reqElements -= targetIndex + 1;
            
            // available no. of elements : no change
            iavailable = 0; 
        } else {
            i = (int)(targetIndex - Math.ceil( (double)reqElements / 2 ));

            // ( - 1 ) : taking the ceil value after dividing
            reqElements =  (int)(Math.ceil( (double)reqElements / 2 ) - 1);

            // available no. of elements :
            iavailable = i;

        }

        // No. of elements after target index < required no. of elements
        if( nums.length-1 - targetIndex < ( reqElements ) ){        
            // k elements not available
            // return null;

            // no. of elements available after target element
            javailable = nums.length-1 - targetIndex;

            // include from i-side if avialable :
            if(iavailable + javailable >= reqElements){
                j = nums.length - 1;
                reqElements -= javailable;
                i -= reqElements;
            }else
                j = -1;        // last index

        } else {
            j = (int)(targetIndex + reqElements);
        }
        
        System.out.println(targetIndex + " " + i + " " + j);

        int flag = 1;
        while (i < targetIndex ){

            // |a - x| < |b - x|, or
            // |a - x| == |b - x| and a < b
            if(Math.abs(nums[i - 1] - nums[targetIndex]) <= Math.abs(nums[j] - nums[targetIndex])){
                flag = 0;
                if(nums[i - 1] < nums[j]){
                    // shift window to the left
                    i--;
                    j--;

                    continue;
                } 
                // else {
                //     // shift window to the right
                //     i++;
                //     j++;
                // }

            } 
            
            break;
        }

        if(flag == 1){
            while (j > targetIndex ){

                // |a - x| < |b - x|, or
                // |a - x| == |b - x| and a < b
                if(Math.abs(nums[i] - nums[targetIndex]) <= Math.abs(nums[j + 1] - nums[targetIndex])){

                    if(nums[i] < nums[j + 1]){
                        // shift window to the left
                        i++;
                        j++;
                    } else {
                        // shift window to the right
                        i++;
                        j++;
                    }
                } else
                    break;
            }
        }

        // return Arrays.asList(Arrays.copyOfRange(nums, i, j+1));
        return null;
    }

}
