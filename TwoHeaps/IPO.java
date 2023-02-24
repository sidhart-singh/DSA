package TwoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {

    class Pair {
        int profit;
        int capital;

        public Pair(){}

        public Pair(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        Pair pair[] = new Pair[profits.length];
        for(int i = 0; i < profits.length; i++){
            pair[i] = new Pair(profits[i], capital[i]);

            minHeap.add(pair[i]);
        }

        // TC: O(k * log(n))
        while(k > 0){
            while(!minHeap.isEmpty() && w >= minHeap.peek().capital){
                maxHeap.add(minHeap.poll());
            } 
            
            /*
             * In case we couldn't add any pair into the minHeap,
             * maxHeap may be empty :
             * break
             * No further inrement in 'w' is possible
             */
            if(maxHeap.isEmpty())
                break;
            w += maxHeap.poll().profit;

            k--;
        }

        return w;
    }
}
