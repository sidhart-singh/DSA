package SlidingWindow;

public class LongestSubarrayAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int res = 0; // max length

        int zeroCount = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            // calculation for j : acc to main condition :
            // here checking zero not one
            if (nums[right] == 0) {
                zeroCount++;
            }

            // MAIN CONDITION : for changing window
            if (zeroCount > 1) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            // num[right] == 1 :
            // check maxlength : windowLength - #(zeros) in the window
            // (right - left + 1) - #(zeros == 1)
            res = Math.max(res, (right - left));
            // increment right
            right++;
        }

        return res;
    }

    // for - pattern
    public int longestSubarrayFor(int[] nums) {
        int j = 0, k = 1;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                k--;
            while (k < 0) {
                if (nums[j] == 0)
                    k++;
                j++;
            }

            ans = Math.max(ans, i - j);
        }

        return ans;
    }
}
