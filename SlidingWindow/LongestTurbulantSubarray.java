package SlidingWindow;

public class LongestTurbulantSubarray {
    public int maxTurbulenceSize(int[] arr) {
        
        // [1] : array with length = 1 is turbulant
        // r = 1 is not less than arr.length
        int result = 1;

        String previousSign = "";
        int l = 0; 
        for(int r = 1; r < arr.length; r++){
            // compute sign for r-th element
            String currentSign;
            if(arr[r-1] < arr[r]) currentSign = "<";
            else if(arr[r-1] > arr[r]) currentSign = ">";
            else currentSign = "=";

            // window valid : 
            // previousSign = '<' currentSign = '>' || previousSign = '>' currentSign = '<'
            if(currentSign == "="){
                l = r;
                previousSign = currentSign;
                continue;
            }
            if(!previousSign.equals(currentSign)){
                // compute result
                result = Math.max(result, r - l + 1);
                // r++;
                // previousSign = currentSign;
            }
            // window invalid :
            // previousSign == currentSign
            else{
                l = r - 1;
                // previousSign = currentSign;
            }

            previousSign = currentSign;
        }

        return result;
    }

    public int maxTurbulenceSizeBest(int[] arr) {
        boolean big=true;
        int prev=arr[0];
        int res=1,c=1;

        for(int i=1;i<arr.length;i++){
            if(big && arr[i]>prev){
                c++;
                big=false;
                prev=arr[i];
            }
            else if(!big && arr[i]<prev){
                c++;
                big=true;
                prev=arr[i];
            }
            else{
                c=arr[i]==prev?1:2;
                prev=arr[i];
            }

            if(c>res) res=c;
        }

        return res;
    }
}
