package BinaryTree;

import java.util.Arrays;
import java.util.Map;

public class Main {

    // public static Node newTreeNode(int value) {
    // return new Node(value);
    // }

    public static void main(String[] args) {

        // BinaryTree bt = new BinaryTree();
        // Node root = bt.createTree();

        // System.out.println("Count of Good Nodes: " +
        // CountGoodNodes.countGoodNode(root, root.data));;

        // isBalanced isBalanced = new isBalanced();
        // System.out.println("isBalanced: " +
        // Arrays.toString(isBalanced.isBalancedUtil(root)));

        // SortedArrayToBST satb = new SortedArrayToBST();
        // System.out.println(Arrays.toString(satb.sortedArrayToBST()));

        // Node root = bt.createTree();
        // ValidateBST vbst = new ValidateBST();
        // System.out.println(String.valueOf(vbst.isValidBST(root)));

        // Node root = newTreeNode(1);
        // root.left = newTreeNode(7);
        // root.right = newTreeNode(0);
        // root.left.left = newTreeNode(7);
        // root.left.right = newTreeNode(-8);

        // Node root = newTreeNode(10);
        // root.left = newTreeNode(20);
        // root.right = newTreeNode(9);
        // root.left.left = newTreeNode(15);
        // root.left.right = newTreeNode(7);

        // BoundaryTraversal bt = new BoundaryTraversal();
        // System.out.println(bt.boundaryTraversal(root));

        // VerticalOrderTraversal vot = new VerticalOrderTraversal();
        // System.out.println(vot.verticalTraverse(root));

        // MaximumLevelSum mls = new MaximumLevelSum();
        // System.out.println(mls.maxLevelSum(root));

        // MaximumPathSum mps = new MaximumPathSum();
        // System.out.println(mps.maxPathSum(root));

        // PathInZigzagLabelledBT pizlbt = new PathInZigzagLabelledBT();
        // pizlbt.pathInZigZagTree(14);

        // MaximumWidthOfBinaryTree mwobt = new MaximumWidthOfBinaryTree();
        // System.out.println(mwobt.widthOfBinaryTree(null));

        // BinaryTree bt = new BinaryTree();
        // Node root = bt.createTree();
        // ChildrenSumProperty csp = new ChildrenSumProperty();
        // csp.dfs(root, 0);

        KthAncestorOfNode kaon = new KthAncestorOfNode();
        System.out.println(kaon.getKthAncestor(3, 2));
    }
}