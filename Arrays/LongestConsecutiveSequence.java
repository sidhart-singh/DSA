package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    
    int nums[] = {0,3,7,2,5,8,4,6,0,1};

    public int longestConsecutive(){

        Set<Integer> set = new HashSet<>();

        for(int n : nums) set.add(n);

        int longestStreak = 0;
        for(int n : nums) {
            if(!set.contains(n - 1)){
                int currentStreak = 1;      //initial value : 1 (minimum streak)
                while(set.contains(n + 1)){
                    currentStreak++;
                    n++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
