package BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    int piles[] = {805306368,805306368,805306368};
    int hours = 1000000000;

    public int minEatingSpeed(){

        int low = 1;
        // piles[] may not be sorted : max(piles) != piles[piles.length]
        int high = Arrays.stream(piles).max().getAsInt();

        int result = -1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(canEat(mid)){
                result = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;

        }

        return result;
    }

    public boolean canEat(int eatSpeed){
        // sum(piles) overflows
        long hoursReq = 0;
        for(int pile : piles)
            hoursReq += ((pile - 1) / eatSpeed) + 1;
            // hoursReq += Math.ceilDiv(pile, eatSpeed); : slower

        return hoursReq <= hours;
    }
}
