package SlidingWindow;

import java.util.*;

public class RepeatedDNASequence {

    String s = "AAAAAAAAAAA";
    int k = 10;

    public List<String> slidingWindow(){

        // Set<String> set = new HashSet<String>();
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        int i = 0; 
        // int j = 0;
        // int k = 10;
        char[] temp;
        char[] s_char = s.toCharArray();

        for(; i< s.length() - (k - 1); i++){

            // calculation for j-th char
            temp = Arrays.copyOfRange(s_char, i, i + 10);

            // window size -> valid :
            
                // calculate temporary answer :
                // add substring to the set
                if(map.containsKey(String.valueOf(temp))){
                    map.put(String.valueOf(temp), map.get(String.valueOf(temp)) + 1);
                }else{
                    map.put(String.valueOf(temp), 1);
                }
                // set.add(String.valueOf(temp));

                // slide window :
                // remove calculation for i-th char
                // increment i
                // i++;
            
        }
        
        for(Map.Entry<String, Integer> e : map.entrySet())
            if(e.getValue() > 1)
                list.add(e.getKey());
        
        return  list;
    }
    
}
