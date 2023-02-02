package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class zigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root){
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){
            Deque<Integer> temp = new ArrayDeque<>();

            // know when the current level ends : for loop accordingly
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();

                if(leftToRight){
                    temp.addLast(node.data);
                } else {
                    temp.addFirst(node.data);
                }

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);

            }
            leftToRight = !leftToRight;

            result.add(List.copyOf(temp));
        }
        
        return result;
    }

    public static Node newTreeNode(int value){
        return new Node(value);
    }

    public static void main(String[] args){
        // Let us create binary tree shown in above diagram
        Node root = newTreeNode(1);
        root.left = newTreeNode(2);
        root.right = newTreeNode(3);
        root.left.left = newTreeNode(4);
        root.left.right = newTreeNode(5);

        zigzagLevelOrderTraversal zlot = new zigzagLevelOrderTraversal();
        System.out.println(zlot.zigzagLevelOrder(root));;
    }
}
