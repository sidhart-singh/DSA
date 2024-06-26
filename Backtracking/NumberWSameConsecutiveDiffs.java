package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberWSameConsecutiveDiffs {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> cur = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (y + K < 10)
                    cur2.add(x * 10 + y + K);
                if (K > 0 && y - K >= 0)
                    cur2.add(x * 10 + y - K);
            }
            System.out.println(cur2);
            cur = cur2;
        }
        return cur.stream().mapToInt(j -> j).toArray();
    }
}
