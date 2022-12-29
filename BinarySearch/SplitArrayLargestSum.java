package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;

class SplitArrayLargestSum {

    private class Pair<T> {
        private final T[] contents;

        public Pair (T[] contents) {
            if (contents.length != 2)
                throw new IllegalArgumentException();
            this.contents = contents;
        }

        public T[] getContents () {
            return this.contents.clone();
        }

        @Override
        public int hashCode () {
            return Arrays.deepHashCode(this.contents);
        }

        @Override
        public boolean equals (Object other) {
            return Arrays.deepEquals(this.contents, ((Pair) other).getContents());
        }

        @Override
        public String toString () {
            return Arrays.deepToString(this.contents);
        }
    }

    int[] nums = { 7,2,5,10,8 };
    int k = 2;

    public int sum(int i) {
        int sum = 0;

        while (i < nums.length)
            sum += nums[i++];

        return sum;
    }

    HashMap<Pair<Integer>, Integer> dp = new HashMap<>();

    public int bruteForceRecursive(int i, int m) {

        if(m == 1)
            return sum(i);

        Integer[] index = new Integer[]{i, m};

        if(dp.containsKey(new Pair(index))){
            return dp.get(new Pair(index));
        }

        int result = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int j = i; j < nums.length + 1 - m; j++){
            currentSum += nums[j];
            int maxSum = Math.max(currentSum, bruteForceRecursive(j+1, m-1));
            result = Math.min(result, maxSum);

            if(currentSum > result)
                break;
        }

        dp.put(new Pair(index), result);

        return result;
    }

    public boolean canSplit(int limit){

        int count = 0;
        int cap = 0;
        for(int i = 0; i < nums.length; i++){
            cap += nums[i];
            if(cap > limit){
                count++;
                cap = nums[i];
            }
        }
        return count + 1 <= k;

    }

    public int binarySearch() {

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int num : nums){
            high += num;
            low = (num > low) ? num : low;
        }

        int result = high;
        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(canSplit(mid)) {
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return result;
    }

    // public static void main(String[] args) {

    // }

}