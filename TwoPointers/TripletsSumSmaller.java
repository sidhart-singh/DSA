package TwoPointers;

import java.util.*;

public class TripletsSumSmaller {

    int[] nums = { -1, 4, 2, 1, 3 };
    int target = 5;

    public int tripletWithSmallerSum () {

        Arrays.sort(nums);

        int count = 0;
        ArrayList<int[]> triplets = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
          count += searchPair(nums, target - nums[i], i, triplets);
        }

        for(var arr : triplets)
            System.out.println(Arrays.toString(arr));

        return count;
      };
      
      public int searchPair(int[] arr, int targetSum, int first, ArrayList<int[]> triplets){
        int count = 0;
        int start = first + 1;
        int end = arr.length - 1;
        
        while(start < end) {
          if(arr[start] + arr[end] < targetSum) {
            //we found the a triplet
            //since arr[end] >= arr[start], therefore, we can replace arr[end]
            //by any number between start and end to get a sum less than the targetSum
            count += end - start;

            for(int i = end; i > start; i--){
                triplets.add(new int[]{arr[first], arr[start], arr[i]});
            }

            start++;
          } else {
            //we need a pair with a smaller sum
            end--;
          }
        }
        return count;
        
      }
}
