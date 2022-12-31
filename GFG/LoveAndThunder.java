package GFG;

import java.util.*;

public class LoveAndThunder {
    Scanner sc = new Scanner(System.in);

    public void test(){

        int tc = sc.nextInt();

        while(tc-- >= 0){
            int size = sc.nextInt();

            int nums[] = new int[size];

            int i = 0;
            while(i<nums.length && sc.hasNext() ){
                nums[i++] = sc.nextInt();
            }
            System.out.println(Arrays.toString(nums));

            // find maximum perfect sum

            

        }

    }

}

// def perfect_sum(nums):
//     even, odd = 0, 0
//     for i in range(0, len(nums), 2):
//         even += nums[i]
//         odd += nums[i+1]

//     res = 0
//     for i, n in enumerate(nums):
//         if i % 2 == 0:
//             res = max(res, n, (even-n)-odd)
//         else:
//             res = max(res, n, even-(odd-n))
//     return res

// if _name_ == '_main_':
//     output = []
//     testcase = int(input())
//     for i in range(testcase):
//         nums = []
//         size = int(input())
//         for j in range(size):
//             n = int(input())
//             nums.append👎
//         res = perfect_sum(nums)
//         output.append(res)
    
//     for n in output:
//         print👎