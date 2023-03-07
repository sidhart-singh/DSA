package Stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/*
 * Push the positive atseroids into the stack and 
 * as we encounter a negative asteroid check stack for collisions
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        while(i < asteroids.length){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            } 
            // checks for collisions
            else {
                while(!stack.isEmpty() && 
                        // we will be pushing the negative asteroids
                        stack.peek() > 0 &&
                        // CASE I: tos < current asteriod
                        stack.peek() < Math.abs(asteroids[i])){
                            stack.pop();
                }

                // stack is empty OR tos is negative : 
                // in case of first iteration 
                // in case the negative asteroid destorys all the stack
                // current asteroid is pushed after the while loop (collisions)
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(asteroids[i]);
                } 
                // CASE II: tos = asteroid
                else if(stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                }
            }

            i++;
        }

        return stack.stream().mapToInt(j -> j).toArray();
    }

    
}
