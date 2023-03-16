package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructBTFromInorderAndPostorder {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Required BinaryTree will not be null

        ArrayList<Integer> inorderList = new ArrayList<Integer>(Arrays.stream(inorder).boxed().collect(Collectors.toList()));
        ArrayList<Integer> postorderList = new ArrayList<Integer>(Arrays.stream(postorder).boxed().collect(Collectors.toList()));
        TreeNode root = buildTreeUtil(inorderList, postorderList);

        return root;
    }

    public TreeNode buildTreeUtil(ArrayList<Integer> inorder, ArrayList<Integer> postorder){
        if(postorder.size() == 0)
            return null;

        // PostOrder : 

        // NODE

        TreeNode root = new TreeNode(postorder.get(postorder.size() - 1));
        // System.out.println("Root: " + root.val);
        // remove(root.val) : index out of bounds exception : root.val as index
        postorder.remove(postorder.size() - 1);
        // System.out.println("Postorder: " + postorder);
        // System.out.println("Inorder: " + inorder);
        

        // LEFT 

        int index = inorder.indexOf(root.val);
        // System.out.println(index + "-" + inorder.size());

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
            root.right = buildTreeUtil(new ArrayList<>(inorder.subList(index + 1, inorder.size())), postorder);}
        else 
            root.right = null;
            

            
        // RIGHT    

        /*
         * index > 0 == index - 1 > -1
         */
        if(inorder.size() > 0 && index > 0){
            // System.out.println("Left: " + inorder.subList(0, index));
            root.left = buildTreeUtil(new ArrayList<>(inorder.subList(0, index)), postorder);}
        else
            root.left = null;

        return root;
    }
}
