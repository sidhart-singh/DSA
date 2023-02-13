package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NamingACompany {
    public long distinctNames1(String[] ideas) {
        
        HashMap<Character, HashSet<String>> wordMap = new HashMap<>();
        long result = 0;

        for(String s : ideas){
            if(wordMap.get(s.charAt(0)) == null)
                wordMap.put(s.charAt(0), new HashSet<>());
            wordMap.get(s.charAt(0)).add(s.substring(1));
        }

        for(Map.Entry<Character, HashSet<String>> e: wordMap.entrySet())
            System.out.println(e);

        for(Map.Entry<Character, HashSet<String>> e1 : wordMap.entrySet()){
            for(Map.Entry<Character, HashSet<String>> e2 : wordMap.entrySet()){
                if(e1.getKey() == e2.getKey())
                    continue;
                
                int intersect = 0;
                for(String word : e1.getValue()){
                    if(e2.getValue().contains(word))
                        intersect++;
                }

                int distinct1 = e1.getValue().size() - intersect;
                int distinct2 = e2.getValue().size() - intersect;

                result += distinct1 * distinct2;
            }
        }

        return result;
    }

    public long distinctNames(String[] ideas){

        // TODO: Use Set<String>[26] and use the indices for hashing with characters
         
        return 0;
    }
}
