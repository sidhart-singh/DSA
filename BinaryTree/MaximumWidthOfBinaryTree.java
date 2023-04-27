package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(Node root) {

        int result = 0; // Max width
        Deque<Node> q = new LinkedList<>();

        int start = 1;
        int end = 1;
        boolean isStart = false;

        root.data = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node current = q.poll();

            // update start : if the current node is the start of the current level :
            // isStart = true
            if (current != null && isStart) {
                start = current.data;
                // set isStart back to false
                isStart = false;
            }
            // update end : if the next value in the queue is null :
            // current node is the last node of the current level
            if (current != null && q.peek() == null)
                end = current.data;

            // end of a level
            if (current == null) {
                // update result :
                // FIRST THING : before checking q.isEmpty
                result = Math.max(result, end - start + 1);
                System.out.println(result);

                // q is empty : traversal complete : break
                if (q.isEmpty())
                    break;
                // mark end of a level
                q.add(null);

                // mark isStart = true : to indicate next node that its the start of the level
                isStart = true;

                continue;
            }

            if (current.left != null) {
                current.left.data = 2 * current.data;
                q.add(current.left);
            }
            if (current.right != null) {
                current.right.data = 2 * current.data + 1;
                q.add(current.right);
            }

        }

        return result;

    }

}
