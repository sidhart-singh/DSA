package SlidingWindow;

import java.util.HashMap;

public class FruitsBasket {
    public int totalFruits(int[] fruits){
        int k = 2;      // types of fruits allowed to pick / number of baskets

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        int i = 0;
        int j = 0;

        while(j < fruits.length){
            if(map.containsKey(fruits[j]))
                map.put(fruits[j], map.get(fruits[j]) + 1);
            else
                map.put(fruits[j], 1);

            // window valid : ' <= ' 
            // count of types fruits <= k is valid, not only ' == ' k
            if(map.size() <= k){
                // calculate the temporary answer
                result = Math.max(result, (j - i + 1));

                // increment j | window : possible longer window
                // j++;
            } else if(map.size() > k){
                // window invalid
                // map.size() > k : types of fruits > allowed 
                // 1. remove calculation for i
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0)
                    map.remove(fruits[i]);
                // 2. increment i
                i++;
            }

            j++;
        }

        return result;
    }
}
