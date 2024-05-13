package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaxEnergyFromMysticDungeon {
    private int dfs(int i, int[] energy, int k, int[] t, Map<Integer, Integer> dp) {
        if (i >= energy.length)
            return t[0];
        if (dp.containsKey(i))
            return dp.get(i);

        t[0] += energy[i];
        dfs(i + k, energy, k, t, dp);

        return t[0];
    }

    public int maximumEnergyMemo(int[] energy, int k) {
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = 0; i < energy.length; i++) {
            int[] t = { 0 };
            dp.put(i, dfs(i, energy, k, t, dp));
            res = Math.max(res, dp.get(i));
        }

        System.out.println(dp);
        return res;
    }

    public int maximumEnergy(int[] energy, int k) {
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = energy.length - 1; i >= 0; i--) {
            // while iterating from back the (i + k)th index will be out of bounds
            // so result for that index would be just energy[i]
            dp.put(i, (i + k < energy.length ? dp.get(i + k) : 0) + energy[i]);
            res = Math.max(res, dp.get(i));
        }

        System.out.println(dp);
        return res;
    }
}
