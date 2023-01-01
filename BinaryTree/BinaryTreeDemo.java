package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


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

public class BinaryTreeDemo {
    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Node root = createTree();
        // rightView(root);
        topView(root);
    }

    static Node createTree () {

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

    static void inOrder (Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    static void preOrder (Node root) {
        if(root == null)
            return;

        System.out.println(root.data);
        inOrder(root.left);
        inOrder(root.right);
    }

    static void postOrder (Node root) {
        if(root == null)
            return;

        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.data);
    }

    static int height (Node root) {
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static void levelOrder (Node root) {
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

    static void printlnlevelOrder(Node root) {
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

    static int size (Node root) {
        if(root == null)
            return 0;
        
        return size(root.left) + size(root.right) + 1;
    }

    static int max (Node root) {
        if(root == null)
            return Integer.MIN_VALUE;

        return Math.max(Math.max(max(root.left), max(root.right)), root.data);
    }

    static void leftView (Node root) {
        ArrayList<Node> list = new ArrayList<>();
                             
        printLeftView(root, list, 0);

        System.out.println("Left View:- ");
        for(Node current : list)
            System.out.println(current.data + " ");
    }

    static void printLeftView(Node root, ArrayList<Node> list, int level) {
        if(root == null) {
            return;
        }
        /*
         * IndexOutOfBoundsException : (index < 0 || index >= size())
         * here 'level' is used as 'index' :               ⬆
         * so cannot access that index
         * must use add()
         */
        if(list.size() == level){
            // cannot use set()
            // list.set(level, root);

            // IndexOutOfBoundsException :                       ⬇
            // if the index is out of range : (index < 0 || index > size())
            list.add(level, root);
        }
        printLeftView(root.left, list, level + 1);
        printLeftView(root.right, list, level + 1);
    }

    static void rightView (Node root) {
        ArrayList<Node> list = new ArrayList<>();
                             
        printLeftView(root, list, 0);
        
        System.out.println("Right View:- ");
        for(Node current : list)
            System.out.println(current.data + " ");
    }
    
    static void printRightView(Node root, ArrayList<Node> list, int level) {
        if(root == null) {
            return;
        }
       
        printLeftView(root.left, list, level + 1);
        printLeftView(root.right, list, level + 1);
    }

    static void topView (Node root) {
        // Pair for holding HorizontalDistance and NodeReference
        class Pair {
            int hd;         // Horizontal Distance
            Node node;      // Node Reference

            // Constructor
            public Pair(int hd, Node node){
                this.hd = hd;
                this.node = node;
            }
        }
        // Queue of Pairs
        Queue<Pair> queue = new ArrayDeque<>();

        Map<Integer, Integer> map = new TreeMap<>();
        
        queue.add(new Pair(0, root));

        /*
         * Level Order Traversal of the tree :
         * Enter the first node encountered for a particular hd
         */
        while(!queue.isEmpty()){
            Pair current = queue.poll();

            // Enter the first Node's data for a particular hd
            // rest are neglected
            if(!map.containsKey(current.hd)){
                map.put(current.hd, current.node.data);
            }

            if(current.node.left != null) {
                queue.add(new Pair(current.hd - 1, current.node.left));
            }
            if(current.node.right != null){
                queue.add(new Pair(current.hd + 1, current.node.right));
            }
        }

        System.out.println("Top View:- ");
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    static void bottomView(Node root){
        // Pair for holding HorizontalDistance and NodeReference
        class Pair {
            int hd;         // Horizontal Distance
            Node node;      // Node Reference

            // Constructor
            public Pair(int hd, Node node){
                this.hd = hd;
                this.node = node;
            }
        }
        // Queue of Pairs
        Queue<Pair> queue = new ArrayDeque<>();

        Map<Integer, Integer> map = new TreeMap<>();
        
        queue.add(new Pair(0, root));

        /*
         * Level Order Traversal of the tree :
         * Last node encountered for a particular hd is considered
         */
        while(!queue.isEmpty()){
            Pair current = queue.poll();

            map.put(current.hd, current.node.data);

            if(current.node.left != null) {
                queue.add(new Pair(current.hd - 1, current.node.left));
            }
            if(current.node.right != null){
                queue.add(new Pair(current.hd + 1, current.node.right));
            }
        }

        System.out.println("Top View:- ");
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    /*
     * Convert the Binary Tree itself to a DoublyLinkedList 
     * in the form of its InOrder Traversal :
     * TreeNode's 'left / right' pointer : DllNode's 'previous / next' pointer
     */
    static Node prev = null;
    static Node head = null;
    static void convertToDLL(Node root){
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
    static int diameter = 0;
    static int diameter (Node root) {
        if (root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(diameter, 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
