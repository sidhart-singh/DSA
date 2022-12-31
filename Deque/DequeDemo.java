package Deque;

import java.util.ArrayDeque;

public class DequeDemo {
    
    public static void main(String[] args) {
        /* ArrayDeque as Doubly Ended Queue */
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.forEach(System.out::println);

        /* ArrayDeque as Queue */
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(10);
        queue.offerLast(30);
        queue.offerLast(40);
        queue.removeFirst();
        
        queue.forEach(System.out::println);

        /* ArrayDeque as Stack */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(10);
        stack.offerFirst(30);
        stack.offerFirst(40);
        stack.removeLast();
        
        stack.forEach(System.out::println);
    }
}
