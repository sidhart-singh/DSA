package Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDistinctCharEqual {

    String word1 = "abbbc";
    String word2 = "bc";

    private void createHashMap(String word1, HashMap<Character, Integer> map1){
        int i = 0;
        while(i < word1.length()){
            char charAt = word1.charAt(i);
            if(map1.containsKey(charAt)){
                map1.put(charAt, map1.get(charAt) + 1);
            } else {
                map1.put(charAt, 1);
            }
            i++;
        }
    }

    public boolean isItPossible(){

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        createHashMap(word1, map1);
        int c1 = map1.size();

        createHashMap(word2, map2);
        int c2 = map2.size();

        // char[] word = word1.toCharArray();

        for(Map.Entry<Character, Integer> e1 : map1.entrySet()){
            for(Map.Entry<Character, Integer> e2 : map2.entrySet()){
                char ec1 = e1.getKey();
                char ec2 = e2.getKey();
                // if(e1.getKey() != e2.getKey()){
                    // System.out.println(word[j] + " " + word2.charAt(k));

                    int u1 = c1;
                    int u2 = c2;
                    // update count of characters in word1 :
                    if(!map1.containsKey(ec2))
                        u1++;
                    if(map1.get(ec1) == 1 && (ec1 != ec2))
                        u1--;

                    if(!map2.containsKey(ec1))
                        u2++;
                    if(map2.get(ec2) == 1 && (ec1 != ec2))
                        u2--;

                    // Check updated count of word1 and word2
                    if(u1 == u2)
                        return true;
                        
                // }
            }
        }

        return false;
    }

}
