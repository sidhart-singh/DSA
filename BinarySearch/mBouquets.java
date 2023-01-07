package BinarySearch;

import java.util.Arrays;

public class mBouquets {
    
    int bloomday[] = { 1,10,3,10,2 };
    int m = 3;      // #bouquets required
    int k = 1;      // #adjacentFlowers required for each bouqet

    public int minDays(){

        int low =  Arrays.stream(bloomday).min().getAsInt();
        int high = Arrays.stream(bloomday).max().getAsInt();
        int result = -1;

        if(m * k > bloomday.length)
            return -1;

        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(canMakeMBouquets(mid)){
                result = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeMBouquets(int days) {

        int bouquets = 0;
        int flowers = 0;
        for(int bloom : bloomday)
            if(bloom > days)
                flowers = 0;
            // SLOW
            // else{
            //     bouquets += (flowers + 1) / k;
            //     flowers = (flowers + 1) % k;
            // }
            else if (++flowers >= k) {
                bouquets++;
                flowers = 0;
            }

        return (bouquets >= m) ? true : false;
    }

    

}
