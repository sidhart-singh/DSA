package SlidingWindow;

public class SubarraysOfKandAvgGTEtoT {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;     // count of subarrays of size k with average greater than or equal to k

        int sum = 0;

        int i = 0;
        int j = 0;
        while(j < arr.length){
            sum += arr[j];
            // window invalid :
            if((j - i + 1) < k){
                // compute for j
                j++;
            } 
            // window valid :
            else if((j - i + 1) == k){
                // compute temporary answer
                if(sum / (j - i + 1) >= threshold)
                    result++;
                j++;
            }
            // window invalid :
            else {
                sum -= arr[i];
                i++;
            }

        }

        return result;
    }
}
