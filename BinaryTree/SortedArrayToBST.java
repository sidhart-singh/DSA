package BinaryTree;

import java.util.ArrayList;

public class SortedArrayToBST {

    int nums[] = { 1,2,3,4,5,6,7 };

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    public void preOrder (TreeNode root, ArrayList<Integer> l) {
        if(root == null)
            return;
        
        l.add(root.data);
        preOrder(root.left, l);
        preOrder(root.right, l);
    }

    public int[] sortedArrayToBST()
    {
        // Creating the BinarySearchTree
        TreeNode root = createBST(nums, 0, nums.length - 1);

        // Traversing the BST in preOrder and storing in the ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);

        // returns an int[] 
        return list.stream().mapToInt(i -> i).toArray();
        
        // returns an Integer[]
        // return list.toArray(new Integer[0]);
    }

    public TreeNode createBST(int[] nums, int low, int high) {
            
        if(low > high)
            return null;
        
        int mid = low + ((high - low) >> 1);
        TreeNode root = new TreeNode();

        // root
        root.data = nums[mid];
        
        // left subtree
        root.left = createBST(nums, low, mid - 1);
        
        // right subtree
        root.right = createBST(nums, mid + 1, high);
        
        return root;
    }
}