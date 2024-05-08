package String;

import java.util.Arrays;

public class WaysToSplitAString {
    // MINE
    private static final int M = 1_000_000_007;

    public int numWays(String s) {
        int count = 0;
        // track the number of ones encountered so far at each index
        int[] ind = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
            ind[i] = count;
        }
        // System.out.println(Arrays.toString(ind));

        if (count % 3 != 0)
            return 0;

        if (count == 0)
            return (int) ((s.length() - 1L) * (s.length() - 2L) / 2 % M);

        // if count % 3 == 0
        int part = count / 3;
        int firstTwo = -1;
        int secondTwo = -1;
        int firstFour = -1;
        int secondFour = -1;
        for (int i = 0; i < s.length(); i++) {
            if (ind[i] == part) {
                if (firstTwo == -1)
                    firstTwo = i;
                secondTwo = i;
            }
            if (ind[i] == 2 * part) {
                if (firstFour == -1)
                    firstFour = i;
                secondFour = i;
            }
        }
        System.out.println(firstTwo + " " + secondTwo + " " + firstFour + " " + secondFour);
        System.out.println((secondTwo - firstTwo + 1) * (secondFour - firstFour + 1));
        long res = ((((long) secondTwo - firstTwo + 1L) % M) * (((long) secondFour - firstFour + 1L))) % M;
        return (int) (res % M);
    }

    private static final int m = 1_000_000_007;

    public int numWays1(String s) {
        int ones = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            ones += s.charAt(i) - '0';
        }
        if (ones == 0) {
            return (int) ((n - 2L) * (n - 1L) / 2 % m);
        }
        if (ones % 3 != 0) {
            return 0;
        }
        int onesInEachSplitedBlock = ones / 3;
        long waysOfFirstCut = 0, waysOfSecondCut = 0;
        for (int i = 0, count = 0; i < n; ++i) {
            count += s.charAt(i) - '0';
            if (count == onesInEachSplitedBlock) {
                ++waysOfFirstCut;
            } else if (count == 2 * onesInEachSplitedBlock) {
                ++waysOfSecondCut;
            }
        }
        long res = (waysOfFirstCut * waysOfSecondCut % m);
        System.out.println(res);
        return (int) (waysOfFirstCut * waysOfSecondCut % m);
    }

    // Best Approach
    public int numWaysBest(String s) {

        // Count the number of '1's in the string, while also saving
        // **THE INDEX TO EACH '1' INTO THE ARRAY 'ones'.**
        byte[] sc = new byte[s.length()];
        s.getBytes(0, s.length(), sc, 0);
        int[] ones = new int[Math.min(sc.length, 6000)];
        int onesCount = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '1') {
                ones[onesCount] = i;
                onesCount++;
            }
        }

        // If number of '1's is not a multiple of 3, then the split
        // can not be done. A '1's count of zero is still a multiple
        // of 3: 3 x 0 == 0.
        if (onesCount % 3 != 0)
            return 0;

        // If no '1's (string is all '0's), then the number of ways
        // to split is calculated from only the string length.
        // Number of split combinations is: 1 + 2 + ... + len-3 + len-2
        // which is the summation of integers from 1 to len-2.
        // The summation formula gives: (len-2)*(len-1)/2
        if (onesCount == 0) {
            return (int) (((long) (s.length() - 2) *
                    (long) (s.length() - 1) / 2L) % 1000000007L);
        }

        // Divide the string into three segments. The number of possible
        // ways to split it is based the number_of_'0's + 1 between the
        // last '1' of a segment and the first '1' of the next segment.
        //
        // We have the array ones[] which contains the index of all '1's
        // in the string, so we divide the array into thirds to find the
        // index of the last '1' of a segment and the index of the first
        // '1' of the next segment. The number of split positions between
        // segments is: start_'1'_index_next - end_'1'_index_prev + 1.
        // For each possible split position between two segments, all split
        // positions between the other segments are possible, so we multiply
        // the number of possible split positions between all segments to
        // get the result to return.
        int end1 = ones[onesCount / 3 - 1];
        int start2 = ones[onesCount / 3];
        int end2 = ones[onesCount * 2 / 3 - 1];
        int start3 = ones[onesCount * 2 / 3];
        return (int) ((long) (start2 - end1) *
                (long) (start3 - end2) % 1000000007L);
    }
}
/*
 * NOTE:
 * 1. for (int i = 0; i < s.length(); i++) {
 * if (ind[i] == part)
 * if (firstTwo == -1)
 * firstTwo = i;
 * else
 * secondTwo = i;
 * if (ind[i] == 2 * part)
 * if (firstFour == -1)
 * firstFour = i;
 * else
 * secondFour = i;
 * }
 *
 * For [1,1,1] - each part should be having one 1s. Thus, only one way to
 * partition.
 * count ind[] for this - [1,2,3]
 * place variables for this = 0 -1 1 -1
 * ↑ ↑
 * Since, we are either setting firstTwo or lastTwo, and both are at same index
 * and so, lastTwo is not being set
 * Same for LastFour.
 * thus -1 and -1
 * 
 * 2. Result could be larger that integer range.
 */