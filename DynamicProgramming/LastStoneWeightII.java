package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/* MEMOIZATION */
/* BOUNDED KNAPSACK */
public class LastStoneWeightII {

    class Pair {
        int i;
        int total;
        
        public Pair(int i, int total){
            this.i = i;
            this.total = total;
        }
    }

    HashMap<Pair, Integer> map = new HashMap<>();

    public int dfs(int[] stones, int stoneSum, int i, int total, int target){
        

        // Base Condition
        if(total >= target || i >= stones.length)
            return Math.abs(total - (stoneSum - total));

        // Memoization
        Pair pair = new Pair(i, total);
        if(map.containsKey(pair)){
            return map.get(pair);
        }
        int result = Math.min(dfs(stones, stoneSum, i + 1, total, target), dfs(stones, stoneSum, i + 1, total + stones[i], target));
        map.put(new Pair(i + 1, total), result);

        return result;
    }

    public int lastStoneWeightII(int[] stones) {
        
        return dfs(stones, Arrays.stream(stones).sum(), 0, 0, (int)Math.ceil(Arrays.stream(stones).sum() / 2));
    }
}
