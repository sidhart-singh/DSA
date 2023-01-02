package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Views {
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
}
