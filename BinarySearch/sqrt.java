package BinarySearch;

public class sqrt {
    public int mySqrt(int x) {

        int result = 0;

        int l = 0;
        int r = x;

        while(l <= r){
            int mid = l + ((r - l) / 2);
            // System.out.println("mid: " + mid);
            long midsq = (long)mid * mid;
            if(midsq > x){
                // mid can't be the answer
                r = mid - 1;
            } else if(midsq < x){
                l = mid + 1;
                // we are rounding down :
                // mid is the nearest value to the sqrt
                result = mid;
            } else {
                // (mid * mid) == x
                return mid;
            }
        }

        return result;
    }

}
