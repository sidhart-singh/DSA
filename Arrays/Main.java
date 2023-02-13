package Arrays;

import java.util.Arrays;

import SlidingWindow.ContainsDuplicateII;

public class Main {
    public static void main(String[] args) {
        // System.out.println((new BrickWall().leastBricks()));

        // MaxScoreAfterKoperations tst = new MaxScoreAfterKoperations();
        // System.out.println(tst.test1());

        // NumberOfDistinctCharEqual nodce = new NumberOfDistinctCharEqual();
        // System.out.println(nodce.isItPossible());
        // nodce.tst();

        // kClosestElement kce = new kClosestElement();
        // System.out.println(kce.findClosestElements());

        // FlipStringToMonotoneIncreasing fstmi = new FlipStringToMonotoneIncreasing();
        // System.out.println(fstmi.minFlipsMonoIncr());

        // LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        // System.out.println(lcs.longestConsecutive());

        // NextGreaterElementII ngeii = new NextGreaterElementII();
        // System.out.println(Arrays.toString(ngeii.nextGreaterElements()));

        // KFrequentElements kfe = new KFrequentElements();
        // System.out.println(Arrays.toString(kfe.topKFrequentII()));

        // FirstMissingPositive fmp = new FirstMissingPositive();
        // System.out.println(fmp.firstMissingPositive(new int[]{1}));

        // NamingACompany nac = new NamingACompany();
        // System.out.println(nac.distinctNames(new String[]{"coffee","donuts","time","toffee"}));
        // System.out.println(nac.distinctNames1(new String[]{"coffee","donuts","time","toffee"}));

        ContainsDuplicateII cd2 = new ContainsDuplicateII();
        System.out.println(cd2.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
