package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

// 0 - 1 Kanpsack Pattern
// Heap
public class MaximumPerformanceOfTeam {

    private class Member {
        int speed;
        int efficiency;
        
        public Member(int speed, int efficiency){
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public String toString(){
            return this.speed + " " + this.efficiency;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        // sorting the arrays according to the efficiency in descending order
        // creating a Member[] to store speed and efficiency
        Member[] memberList = new Member[n];
        IntStream.range(0, n).forEach(i -> memberList[i] = new Member(speed[i], efficiency[i]));
        // for(int i = 0; i < n; i++){
        //     // memberList[i] = new Member(speed[i], efficiency[i]);
        //     memberList[i].speed  = speed[i];
        //     memberList[i].efficiency = efficiency[i];
        // }

        // sorting the memberList according to efficiency in desc
        Arrays.sort(memberList, new Comparator<Member>() {
            public int compare(Member a, Member b){
                return Integer.compare(b.efficiency, a.efficiency);
            }
        });
        // System.out.println(Arrays.toString(memberList));

        // MinHeap of (k - 1) members with highest speed before the current member
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long maxPerformance = Integer.MIN_VALUE;
        long prefixSpeedSum = 0;
        // for(int i : IntStream.range(0, n).toArray()){
        //     // performance = speed of k members * min(efficiency of those k members) :
        //     //             = (sum of (k-1) speeds from minHeap + current member's speed) * currentMember's eff:
        //     // current member's efficiency is the min eff among the k members considered :
        //     // the memberList is sorted acc. to eff
        //     int currentPerformance = minHeap.stream().mapToInt(j -> j).sum() * memberList[i].efficiency;
            
        //     // add current member's speed to minHeap
        //     minHeap.add(memberList[i].speed);
        //     // if min heap size == k : remove the min speed
        //     if(minHeap.size() == k) minHeap.poll();

        //     maxPerformance = Math.max(currentPerformance, maxPerformance);
        // }

        for(int i = 0; i < n; i++){
            
            prefixSpeedSum += memberList[i].speed;
            minHeap.add(memberList[i].speed);
            if(minHeap.size() > k){
                prefixSpeedSum -= minHeap.poll();
            }
            maxPerformance = Math.max(maxPerformance, prefixSpeedSum * memberList[i].efficiency);
        }

        return (int)maxPerformance % ((int)Math.pow(10, 9) + 7);
    }   
}
