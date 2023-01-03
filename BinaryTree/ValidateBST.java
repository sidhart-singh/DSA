package BinaryTree;

public class ValidateBST {
 
    public boolean isValidBST(Node root){

        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean isValidBSTUtil(Node root, int lowerBound, int upperBound) {
        
        if(root == null)
            return true;
        
        // PostOrder : Node -> Left -> Right
        
        // Node
        boolean lChild = true;
        boolean rChild = true;
        if(root.left != null)
            lChild = (lowerBound <= root.left.data && root.left.data <= root.data) ? true : false;
        
        if(root.right != null)
            rChild = (root.data < root.right.data && root.right.data <= upperBound) ? true : false;
        
        if (!lChild || !rChild)
            return false;
        
        
        boolean lSubtree = true;
        boolean rSubtree = true;
        if(root.left != null)
            lSubtree = isValidBSTUtil(root.left, lowerBound, root.data);
        if(root.right != null)
            rSubtree = isValidBSTUtil(root.right, root.data, upperBound);


        return (lSubtree && rSubtree) ? true : false;
    }

}
