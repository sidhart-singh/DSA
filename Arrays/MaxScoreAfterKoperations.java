package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxScoreAfterKoperations {
    
    int[] nums = {238838724,196963851,539418658,120132686,273213807,57187185,68854249,619718192};
    int k = 7;
    public long test1(){
        PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
 
        for(int n : nums)
            pQueue.add(n);

        // System.out.println(pQueue.peek());
        long result = 0;
        while(k > 0){
            int cm = pQueue.peek();
            result += cm;

            pQueue.poll();

            pQueue.add((int)Math.ceil(cm/3.0));

            k--;
        }

        return result;
    }
}
