package GFG;

import java.util.*;

public class ClassTest {

    Scanner sc = new Scanner(System.in);
		
    public void test(){

        int tc = sc.nextInt();
    
        while(tc > 0){
            int mark = sc.nextInt();
            int next = 0;

            // int i = 0;
            if(mark == 0 || mark % 3 == 0){
                System.out.println(0);
                tc--;
                continue;
            } else {
                // int rem = mark % 3;
                // next = mark + (mark % 3);

                while (next < mark){
                    next = next + 3;
                }

            }

            System.out.println(next + " " + (next - mark));
            tc--;
        }

    }

}