package Java.Assignment_K;

// Comparator Interface
import java.util.Comparator;
// Collections.reverseOrder()
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo1 {
    // Priority Queue, by default implements min Priority Queue
    PriorityQueue<Integer> minpq = new PriorityQueue<>();

    //Implement Max PriorityQueue:


    // 1. The Collections.reverseOrder()/Comparator.reverseOrder() method is used to get a reverse behavior of the default comparator.
    PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

    // 2. Custome Comparator
    PriorityQueue<Integer> maxpqc = new PriorityQueue<Integer>(new Comparator<Integer>(){

        @Override
        // Compare method for place element in reverse order
        public int compare(Integer a, Integer b)
        {
            if (a < b)
                return 1;
            if (a > b)
                return -1;
            return 0;
        }

    });

    // 3. Lambda Expression
    PriorityQueue<Integer> maxpql = new PriorityQueue<Integer>((a, b) -> b - a);
    
    
}
