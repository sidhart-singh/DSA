package SlidingWindow;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        /* Average of Subarrays */
        // MaxAveragesOfSubarray aos = new MaxAveragesOfSubarray();
        // aos.bruteForce();
        // System.out.println("Max Average: " + aos.slidingWindow());

        /*
         * Count occurrences of Anagrams
         * ERROR - In indices of anagrams
         */
        // CountOccurrencesOfAnagrams coa = new CountOccurrencesOfAnagrams();
        // coa.bruteForce();
        // coa.slidingWindow();

        /* BestTimeToBuyAndSellStocks */
        // BestTimeToBuyAndSellStocks_I bss = new BestTimeToBuyAndSellStocks_I();
        // System.out.println(bss.slidingWindow());

        /* LongestSubstringWithoutRepeatingChar */
        // var lswrc = new LongestSubstringWithoutRepeatingChar();
        // System.out.println(lswrc.slidingWindow_III());

        /* LongestRepeatingCharRelacement */
        // LongestRepeatingCharReplacement lrcr = new LongestRepeatingCharReplacement();
        // System.out.println(lrcr.slidingWindow());

        /* Permutation Of String */
        // PermutationOfString pos = new PermutationOfString();
        // System.out.println(pos.slidingWindow());

        /* Permutation Of String */
        // FrequencyOfMostFrequentElement fomfe = new FrequencyOfMostFrequentElement();
        // System.out.println(fomfe.slidingWindow());

        /* MinimumSizeSubarraySum */
        // MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
        // System.out.println(msss.slidingWindow());

        /* RepeatedDNASequence */
        // RepeatedDNASequence rds = new RepeatedDNASequence();
        // System.out.println(rds.slidingWindow());

        // System.out.println(new SubarraySumEqualK().slidingWindow());

        // System.out.println(new KClosestElements().slidingWindow());

        // System.out.println(new MaxConsecutiveOnesIII().slidingWindow());

        // SubarrayProductLessThanK
        // System.out.println(new
        // SubarrayProductLessThanK().numSubarrayProsuctLessThanK());

        // FruitsBasket fb = new FruitsBasket();
        // System.out.println(fb.totalFruits(new int[]{1,2,3,2,2}));

        // SubarraysOfKandAvgGTEtoT soka = new SubarraysOfKandAvgGTEtoT();
        // System.out.println(soka.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3},
        // 3, 5));

        // LongestTurbulantSubarray lts = new LongestTurbulantSubarray();
        // System.out.println(lts.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));

        // SlidingSubarrayBeauty ssb = new SlidingSubarrayBeauty();
        // System.out.println(Arrays.toString(ssb.getSubarrayBeauty(new int[] { -3, 1,
        // 2, -3, 0, -3 }, 2, 1)));

        // LongestEqualSubarray les = new LongestEqualSubarray();
        // System.out.println(les.longestEqualSubarray(List.of(1, 1, 2, 2, 1, 1), 2));

        // MaximizeConfusionOfExam mcoe = new MaximizeConfusionOfExam();
        // mcoe.maxConsecutiveAnswers("TTFTTFTT", 1);

        LongestSubarrayAfterDeletingOneElement lsadoe = new LongestSubarrayAfterDeletingOneElement();
        lsadoe.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 });
    }
}