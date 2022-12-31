package BinarySearch;

public class NthDigit {

    int n = 10;

    public int findNthDigit() {
        int length = 1; // number of digits in the required/target number
        int count = 9;  // count of digits present in the range

        while (n > length * count) {
            n -= length * count;
            length += 1;
            count *= 10;
        }

        int startNum = (int)Math.pow(10, length - 1);
        int number = n / length;
        int remainder = n % length;
        String s = Integer.toString(startNum + number - 1);

        if (remainder == 0)
            return Character.getNumericValue(s.charAt(s.length() - 1));
        else 
            return Character.getNumericValue(s.charAt(remainder - 1));

    }
    
    
    /*	
        public int findNthDigit(int n) {
            int len = 1;
            long count = 9;
            int start = 1;
    
            while (n > len * count) {
                n -= len * count;
                len += 1;
                count *= 10;
                start *= 10;
            }
    
            start += (n - 1) / len;
            String s = Integer.toString(start);
            return Character.getNumericValue(s.charAt((n - 1) % len));
        }
    */
}
