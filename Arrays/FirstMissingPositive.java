package Arrays;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositiveLambda(int[] nums) {
        int n = nums.length;
        final int[] numsCopy = Arrays.stream(nums)          // IntStream
                        .map(i -> (i < 1) ? n + 2 : i)      
                        .toArray();                         // IntStream -> [] of primitive type

        Arrays.stream(numsCopy).forEach(i -> System.out.print(i + " "));

        Arrays.stream(numsCopy)
                    .forEach(i -> {
                        if(i <= n && i > -1)
                            numsCopy[i - 1] = numsCopy[i - 1] * (-1);
                    });
                    
        System.out.println();
        Arrays.stream(numsCopy).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // return Arrays.stream(numsCopy)
        //             .filter(i -> {if(i > 0) return i;})
        //             .findFirst()
        //             .orElse(n);
        
        for(int i = 0; i < n; i++){
            if(numsCopy[i] > 0)
                return i + 1;
        }
        return n;
    }

    public int firstMissingPositive(int[] nums){

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 1)
                nums[i] = nums.length + 2;
        }
        // System.out.println(nums.toString());
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
        System.out.println();

        for(int i = 0; i < nums.length; i++){
            int j = Math.abs(nums[i]) - 1;
            if(j > -1 && j < nums.length ){
                nums[j] = (nums[j] > 0) ? nums[j] * (-1) : nums[j]; 
            }
        }
        // System.out.println(nums.toString());
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
        System.out.println();
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] > 0)
                return i + 1;
        }

        return i + 1;
    }
}
