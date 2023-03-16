package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructBTFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Required BinaryTree will not be null

        ArrayList<Integer> inorderList = new ArrayList<Integer>(Arrays.stream(inorder).boxed().collect(Collectors.toList()));
        ArrayList<Integer> preorderList = new ArrayList<Integer>(Arrays.stream(preorder).boxed().collect(Collectors.toList()));
        TreeNode root = buildTreeUtil(inorderList, preorderList);

        return root;
    }

    public TreeNode buildTreeUtil(ArrayList<Integer> inorder, ArrayList<Integer> preorder){
        if(preorder.size() == 0)
            return null;

        // preorder : 

        // NODE

        TreeNode root = new TreeNode(preorder.get(0));
        // System.out.println("Root: " + root.val);
        // remove(root.val) : index out of bounds exception : root.val as index
        preorder.remove(0);
        // System.out.println("preorder: " + preorder);
        // System.out.println("Inorder: " + inorder);
        
        int index = inorder.indexOf(root.val);
        // System.out.println(index + "-" + inorder.size());

        // LEFT 

        /*
         * index > 0 == index - 1 > -1
         */
        if(inorder.size() > 0 && index > 0){
            // System.out.println("Left: " + inorder.subList(0, index));
            root.left = buildTreeUtil(new ArrayList<>(inorder.subList(0, index)), preorder);}
        else
            root.left = null;


        // RIGHT    

        // list.subList(0, 0) : same 'start' and 'end' : []
        // if sublist is empty :
        // just assign null : no recursive call

        /*
         * index < inorder.size() - 1 == index + 1 < inorder.size() :
         * 
         * never a recursive call with empty sublist :
         * assignign null
         */
        if(inorder.size() >= 1 && index < inorder.size() - 1){
            // System.out.println("Right: " + inorder.subList(index + 1, inorder.size()));
            root.right = buildTreeUtil(new ArrayList<>(inorder.subList(index + 1, inorder.size())), preorder);}
        else 
            root.right = null;

        return root;
    }
}
