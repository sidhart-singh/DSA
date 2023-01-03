package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    public Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    
    // public void main(String[] args) {
    //     sc = new Scanner(System.in);

    //     Node root = createTree();
    //     // rightView(root);
    //     // topView(root);

    //     burn(root, 3);
    //     System.out.println("Minimum time to burn: " + minTimeToBurn);
    // }

    public Node createTree () {
        Scanner sc = new Scanner(System.in);

        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if(data == -1)
            return null;
        root = new Node(data);

        System.out.println("Enter data for left of: " + data);
        root.left = createTree();

        System.out.println("Enter data for right of: " + data);
        root.right = createTree();

        return root;
    }

    public void inOrder (Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public void preOrder (Node root) {
        if(root == null)
            return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder (Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.data);
    }

    public int height (Node root) {
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public void levelOrder (Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while( !queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data);

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }

    }

    public void printlnlevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while( !queue.isEmpty()) {
            Node current = queue.poll();

            if(current == null) {
                if(queue.isEmpty())
                    return;
                queue.add(null);
                System.out.println();
                
                continue;
            }

            System.out.println(current.data);

            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public int size (Node root) {
        if(root == null)
            return 0;
        
        return size(root.left) + size(root.right) + 1;
    }

    public int max (Node root) {
        if(root == null)
            return Integer.MIN_VALUE;

        return Math.max(Math.max(max(root.left), max(root.right)), root.data);
    }


    /*
     * Convert the Binary Tree itself to a DoublyLinkedList 
     * in the form of its InOrder Traversal :
     * TreeNode's 'left / right' pointer : DllNode's 'previous / next' pointer
     */
    Node prev = null;
    Node head = null;
    public void convertToDLL(Node root){
        if(root == null)
            return;

        /* InOrder : LeftNodeRight */
        // Left
        convertToDLL(root.left);

        // Current Node 
        if(prev == null)        // prev == null only for the first time
            head = root;

        else {
            root.left = prev;   // current node's left -> previous node 
            prev.right = root;  // previous node's right -> current node
        }
        prev = root;            // previous != null for the second time onwards

        // Right
        convertToDLL(root.right);
    }

    // Diameter : Maximum distance between :
    // diameter variable will store the result
    public int diameter = 0;
    public int diameter (Node root) {
        if (root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(diameter, 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // wrapper class for depth : for recursion
    private class Depth {
        int d;
        public Depth(int depth){
            this.d = depth;
        }
    }

    public int minTimeToBurn = 0;
    public int burn(Node root, int key){
        Depth depth = new Depth(-1);
        burnUtil(root, key, depth);

        return minTimeToBurn;
    }

    public int burnUtil(Node root, int key, Depth depth) {
        if (root == null)
            return 0;
        if(root.data == key){
            depth.d = 1;
            return 1;
        }

        Depth leftDepth = new Depth(-1);
        Depth rightDepth = new Depth(-1);

        int leftHeight = burnUtil(root.left, key, leftDepth);
        int rightHeight = burnUtil(root.right, key, rightDepth);

        // Key is present in left subtree
        if(leftDepth.d != -1){
            minTimeToBurn = Math.max(minTimeToBurn, leftDepth.d + 1 + rightHeight);
            depth.d = leftDepth.d + 1;
        } 
        // Key is present in right subtree
        else {
            minTimeToBurn = Math.max(minTimeToBurn, rightDepth.d + 1 + leftHeight);
            depth.d = rightDepth.d + 1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
