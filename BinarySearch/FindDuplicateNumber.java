package BinarySearch;

import java.util.Arrays;

public class FindDuplicateNumber {

    /*
     * Note that the key is to find an integer in the array [1,2,…,n][1, 2, \dots,
     * n][1,2,…,n] instead of finding an integer in the input array.
     * 
     * We can use the binary search algorithm, each round we guess one number, then
     * scan the input array, narrow the search range, and finally get the answer.
     * 
     * So guess a number first(the number midmidmid in the valid range
     * [left,right][left, right][left,right]), count the elements of the array which
     * is less than or equal to midmidmid in the array.
     * 
     * 1. If cntcntcnt is strictly greater than midmidmid. According to the
     * Pigeonhole Principle, repeated elements are in the interval [left,mid][left,
     * mid][left,mid];
     * 2. Otherwise, the repeated element is in the interval [mid+1,right][mid + 1,
     * right][mid+1,right].
     * 
     */
    private int bs(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        return bs(nums);
    }

    /*
     * Start from nums[n]\textit{nums}[n]nums[n] as a new index, and so on, until
     * the index exceeds the bounds. This produces a sequence similar to a linked
     * list.
     * 
     * 0→1→3→2→4→null0 \to 1 \to 3 \to 2 \to 4 \to null0→1→3→2→4→null
     */
    public int findDuplicate_fastSlow(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}