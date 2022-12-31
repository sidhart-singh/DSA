package Java.Assignment_I;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>();

        Collections.addAll(first, 10, 20, 30, 40, 50);
        
        System.out.println(first);
        
        first.add(4, 60);
        
        first.forEach(n -> System.out.println(n));

        if(first.indexOf(30) == -1)
            System.out.println("30 is not present");    
        else
            System.out.println("Position of 30: " + first.indexOf(30));

        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(-60, -70, -80));

        first.addAll(second);

        System.out.println(first);

        first.add(3, 999);

        System.out.println(first);
        
        System.out.println("Addition of 0th and 2nd element of first: " + Integer.sum(first.get(0), first.get(2)));

        first.set(0, 111);

        System.out.println(first);

        /* remove(Object o) */
        first.remove(new Integer(-80));

        System.out.println("Count of elements in first: " + Integer.sum(first.size(), 1));

        /* Using Lambda */
        // first.sort((a, b) -> (a < b) ? -1 : 1);

        /* Using Comparator.naturalOrder() method
         * Collections doesn't have a naturalOrder()
         */
        first.sort(Comparator.naturalOrder());
        System.out.println("Ascending: " + first);

        /* Using Collections.sort() with Collections.reverseOrder()/Comparator.reverseOrder() */
        Collections.sort(first, Collections.reverseOrder());
        System.out.println("Descending: " + first);

    }
}
