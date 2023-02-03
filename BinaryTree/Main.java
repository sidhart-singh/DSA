package BinaryTree;

import java.util.Arrays;
import java.util.Map;

public class Main {

    public static Node newTreeNode(int value){
        return new Node(value);
    }

    public static void main(String[] args) {

        // BinaryTree bt = new BinaryTree();
        // Node root = bt.createTree();
        
        // System.out.println("Count of Good Nodes: " + CountGoodNodes.countGoodNode(root, root.data));;
        
        // isBalanced isBalanced = new isBalanced();
        // System.out.println("isBalanced: " + Arrays.toString(isBalanced.isBalancedUtil(root)));

        // SortedArrayToBST satb = new SortedArrayToBST();
        // System.out.println(Arrays.toString(satb.sortedArrayToBST()));

        // Node root = bt.createTree();
        // ValidateBST vbst = new ValidateBST();
        // System.out.println(String.valueOf(vbst.isValidBST(root)));

        Node root = newTreeNode(1);
        root.left = newTreeNode(7);
        root.right = newTreeNode(0);
        root.left.left = newTreeNode(7);
        root.left.right = newTreeNode(-8);

        // BoundaryTraversal bt = new BoundaryTraversal();
        // System.out.println(bt.boundaryTraversal(root));

        // VerticalOrderTraversal vot = new VerticalOrderTraversal();
        // System.out.println(vot.verticalTraverse(root));

        MaximumLevelSum mls = new MaximumLevelSum();
        System.out.println(mls.maxLevelSum(root));
        
    }
}