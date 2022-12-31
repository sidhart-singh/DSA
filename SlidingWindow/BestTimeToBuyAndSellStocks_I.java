package SlidingWindow;

public class BestTimeToBuyAndSellStocks_I {

    private int[] input = { 7, 1, 5, 3, 6, 4 };

    public int bruteForce() {
        int max_profit = 0;

        for (int i = 0; i < input.length; i++) {
            int profit = 0;

            for (int j = i + 1; j < input.length; j++) {
                if (input[i] < input[j]) {
                    profit = Math.max(profit, input[j] - input[i]);
                }
            }

            max_profit = Math.max(max_profit, profit);

        }

        return max_profit;
    }

    public int slidingWindow() {

        // int start = input.length - 1; // start is never used
        int end = input.length - 1;

        int maxSoFar = input[end];
        int maxProfit = 0;
        while (end >= 0) {

            // calculate for j-th element
            maxSoFar = Math.max(maxSoFar, input[end]);
            maxProfit = Math.max(maxProfit, maxSoFar - input[end]);

            // slide window
            /*
             * HERE : we are increasing window size
             * from end toward the start of the array
             * 
             * No need to slide
             */
            end--;

        }

        return maxProfit;
    }
}
