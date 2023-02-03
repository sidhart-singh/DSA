package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NextGreaterElementII {
    
    int[] nums = { 7, 1, 5, 3, 6, 4 };

    public int[] nextGreaterElements(){

        // int[] result = new int[nums.length];
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = nums.length - 1; i >= 0; i--){
            // if(!stack.isEmpty())
            //     // pop() : he element at the front of this deque 
            //     // (which is the top of the stack represented by this deque)
            //     // front of deque : top of stack
            //     while()
            if (!stack.isEmpty())  
            {  
                while (!stack.isEmpty()
                    && stack.peek() <= nums[i])
                {
                    stack.pop();
                }  
            }

            stack.push(nums[i]);
        }

        for(int i = nums.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                result.add(-1);
                stack.push(nums[i]);
                continue;
            }

            if(stack.peek() > nums[i])
                result.add(stack.peek());
            else 
                while(stack.peek() <= nums[i]) stack.pop();

            stack.push(nums[i]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
