package BinaryTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree();
        isBalanced isBalanced = new isBalanced();

        // System.out.println("Count of Good Nodes: " + CountGoodNodes.countGoodNode(root, root.data));;
        System.out.println("isBalanced: " + Arrays.toString(isBalanced.isBalancedUtil(root)));
    }
}