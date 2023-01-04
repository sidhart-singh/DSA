package BinarySearch;

import java.util.Arrays;

// Capacity to ship packages within d-days.
public class CapacityToShipPackages {
    int weights[] = { 1,2,3,1,1 };
    int days = 4;

    public int shipWithinDays(){

        int low = weights[0];
        int high = Arrays.stream(weights).sum();
        int result = 0;
        // mid is included in search space : (high = mid)
        // (low <= high) results in infinite loop : (low < high)
        while(low <= high){
            int mid = low + ((high - low) >> 1);

            if(canShip(weights, mid)){
                result = mid;
                // weights[mid] is a possible answer : keeping mid in the search space
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canShip(int weights[], int capacity){
        int count = 0;
        int cap = 0;
        for(int i = 0; i < weights.length; i++){
            // int weights[] = { 1,2,3,1,1 }; int days = 4;
            if(weights[i] > capacity)
                return false;
                
            cap += weights[i];
            if(cap > capacity){
                count++;
                cap = weights[i];
            }
        }
        return count + 1 <= days;
    }
}
