package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElements {
    int nums[] = { 1,1,1,2,2,3 };
    int k = 2;

    public int[] topKFrequent(){
        /* 
         * maxHeap : 
         * TC : O(k * log(n))
         * SC : O(n)
         */

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Max Heap of Entries : comparing values of the entries
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue())
        );

        for (int n : nums){
            if(!freq.containsKey(n))
                freq.put(n, 1);
            else
                freq.put(n, freq.get(n) + 1);
        }

        for(Map.Entry<Integer, Integer> e : freq.entrySet()){
            maxHeap.add(e);
        }

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++)
            // maxHeap.poll() return entry 
            result[i] = maxHeap.poll().getKey();

        return result;
    }

    public int[] topKFrequentII(){

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int n : nums){
            if(!freq.containsKey(n))
                freq.put(n, 1);
            else
                freq.put(n, freq.get(n) + 1);
        }

        // ERROR : List<Integer>[] result = new ArrayList<>[nums.length + 1];
        //                                               ^
        List<Integer>[] resultList = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> e : freq.entrySet()){
            resultList[e.getValue()].add(e.getKey()); 
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(List<Integer> list : resultList)
            if(list != null)
                result.addAll(list);

        return result.stream().mapToInt(i->i).toArray();
    }
}
