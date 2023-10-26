package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularPermutationBinaryRepresentaton {
    public List<Integer> grayCodeOptimal(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 1; i <= n; i++) {
            List<Integer> rev = new ArrayList<>(list);
            Collections.reverse(rev);
            int val = (int) Math.pow(2, i - 1);
            for (int v : rev)
                list.add(v + val);
        }

        return list;
    }

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> gcs = grayCodeOptimal(n);
        int c = gcs.indexOf(start);
        System.out.println(gcs);
        System.out.println(c);
        for (int i = 0; i < c; i++) {
            // remove() : Returns the element that was removed from the list.
            gcs.add(gcs.remove(0));
        }
        System.out.println(gcs);
        return gcs;
    }
}
