package GFG;

import java.util.*;

public class FindingCoolest {
    Scanner sc = new Scanner(System.in);
		
    public void test(){

        int tc = sc.nextInt();
    
        while(tc > 0){
            int n = sc.nextInt();
            Long result = 1L;

            while(n > 0){
                if(n%2 == 0){
                    result *= 4;
                } else {
                    result *= 5;
                }
                n--;
            }

            System.out.println(result % (1000000007));
            tc--;

        }

    }
}
