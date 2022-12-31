package SlidingWindow;

class MaxAveragesOfSubarray {

    int arr[] = { 1, 3, 2, 6, -1 };
    int k = 3;

    public void bruteForce() {
        double max_avg = 0;
        for (int i = 0; i <= arr.length - k; i++) {

            int temp_sum = 0;
            for (int j = i; j < i + k; j++) {

                temp_sum += arr[j];
                // System.out.print(arr[j] + " ");
            }

            // System.out.println();

            if (temp_sum > max_avg)
                max_avg = (double) temp_sum / k;
        }

        System.out.println("Max Average: " + max_avg);
    }

    public double slidingWindow() {
        int sum = 0;
        int i = 0;
        int j = 0;

        double max_avg = 0;

        while (j < arr.length) {

            // Calculation : j
            sum += arr[j];

            // (j - i + 1) < K
            // increment j : until window size is less than K
            if ((j - i + 1) < k) {
                j++;
            }

            // (j - i + 1) = K
            else if ((j - i + 1) == k) {
                // 1. calculate an answer for the window
                max_avg = Math.max(sum / k, max_avg);

                // 2. Slide the window
                // remove calculation of i
                max_avg -= (double) arr[i] / k;

                // increment i and j
                i++;
                j++;

            }

        }
        // System.out.println("Max Average: " + max_avg);
        return max_avg;
    }

}
