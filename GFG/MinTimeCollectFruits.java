package GFG;

import java.util.HashMap;

public class MinTimeCollectFruits {
    int locations[] = {1,3,5,7};
    int types[] = {1,2,3,1};

    public int minTime(){
        int min = Integer.MAX_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < locations.length; i++){
            if(map.containsKey(types[i])){
                
            }
        }

        return min;
    }

}
