package BinaryTree;

import java.util.ArrayList;

public class BoundaryTraversal {

    void traverseLeft(Node root, ArrayList<Integer> result){
        // if root : null OR root : leaf 
        if(root == null || (root.left == null && root.right == null))
            return;
        
        result.add(root.data);

        if(root.left != null)
            traverseLeft(root.left, result);
        else
            traverseLeft(root.right, result);

    }

    void traverseLeaf(Node root, ArrayList<Integer> result){
        // if root : null
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            result.add(root.data);
            return;
        }

        // Traverse both left and right subtree
        traverseLeaf(root.left, result);
        traverseLeaf(root.right, result);
    }

    void traverseRight(Node root, ArrayList<Integer> result){
        if(root == null || (root.left == null && root.right == null))
            return;
        
        // PostOrder : Left -> Right -> Node

        if(root.right != null)
            traverseRight(root.right, result);
        else    
            traverseRight(root.left, result);
            
        result.add(root.data);
        
    }

    ArrayList<Integer> boundaryTraversal(Node root){

        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        result.add(root.data);

        traverseLeft(root.left, result);

        traverseLeaf(root.left, result);
        traverseLeaf(root.right, result);

        traverseRight(root.right, result);

        return result;
    }
}
