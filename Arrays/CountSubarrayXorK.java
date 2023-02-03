package Arrays;

import java.util.HashMap;

public class CountSubarrayXorK {

    int arr[] = { 4, 2, 2, 6, 4 };
    int N = arr.length;
    int K = 6;
    
    public int subsetXOR(){   
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int x=0;
        for(int i=0;i<N;i++)
        {
            x^=arr[i];
            
            if(x==K)
            {
                count++;
            }
            int r=K^x;
            if(map.get(r)!=null)
            {  
                count+=map.get(r);
            }
            if(map.get(x)==null)
            {
                map.put(x,1);
            }
            else
            {
                map.put(x,map.get(x)+1);
            }
            
        }
        return count;
    }
}
