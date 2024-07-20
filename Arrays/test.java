package Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static long findMin(List<Long> A, long k) {
        // Write your code here
        int n = A.size();
        Collections.sort(A);

        if (A.get(0) != 1)
            return 1;

        int curidx = 1, curpos = 0, wt = 1;
        for (int day = 1; day <= k + 1; ++day) {
            curpos += wt;
            while (curidx < A.size() && curpos >= A.get(curidx)) {
                wt++;
                curidx++;
                curpos++;
            }
        }

        System.out.println(curpos);
        return curpos;

    }
}
