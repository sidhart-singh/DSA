package Sorting;

public class KthLargestElement {
    private int quickSelect(int[] n, int k, int start, int end) {

        if (start >= end)
            return n[end];

        int pind = start;
        int pele = n[end];

        int temp;
        for (int i = start; i < end; i++) {
            if (n[i] <= pele) {
                temp = n[i];
                n[i] = n[pind];
                n[pind] = temp;

                pind++;
            }
        }
        temp = n[pind];
        n[pind] = n[end];
        n[end] = temp;

        if (pind == k)
            return n[pind];
        else if (pind < k)
            return quickSelect(n, k, pind + 1, end);
        else
            return quickSelect(n, k, start, pind - 1);

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
}
