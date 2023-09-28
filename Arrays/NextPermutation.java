package Arrays;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums.length == 1)
            return;

        // 1. find the break point index
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Check if break point exists.
        if (index == -1) {
            // reverse
            reverse(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));

            // List<Integer> collect =
            // Arrays.stream(nums).boxed().collect(Collectors.toList());
            // Collections.reverse(collect);

            return;
        }

        System.out.println("Index: " + index);
        // 2. find the next greater digit to right of the 'index' and swap
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

        // 3. Reverse the rest elements to the right of the index.
        if (index + 1 < nums.length) {
            reverse(nums, index + 1, nums.length - 1);
        }

        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
