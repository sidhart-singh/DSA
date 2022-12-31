package Java.Practical;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetCompare {

    public static void main(String[] args) {
        HashSet<String> first = new HashSet<>(Arrays.asList("Red", "White", "Black", "Green"));
        HashSet<String> second = new HashSet<>(Arrays.asList("Red", "Pink", "Black", "Orange"));

        for(var fItem : first){
            if(second.contains(fItem))
                System.out.println(fItem);
        }

        // first is modified
        first.retainAll(second);
        HashSet<String> inter = new HashSet<>(first);
        System.out.println(inter);
    }
}
