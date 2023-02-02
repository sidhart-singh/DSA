package BinaryTree;

public class isSumTree {
    class Pair{
        boolean isSumTree;
        int sum;
        
        Pair(boolean sT, int s){
            this.isSumTree = sT;
            this.sum = s;
        }
    }
    
	Pair isSumTreeFast(Node root)
	{
        if(root == null){
            return new Pair(true, 0);
        }
        if(root.left == null && root.right == null)
            return new Pair(true, root.data);
        
        Pair left = isSumTreeFast(root.left);
        Pair right = isSumTreeFast(root.right);
        
        boolean leftAns = left.isSumTree;
        boolean rightAns = right.isSumTree;
        boolean condition = (root.data == (left.sum + right.sum)) ? true : false;
        
        Pair result = new Pair(false, 0);
        if(leftAns && rightAns && condition){
            result.isSumTree = true;
            result.sum = 2 * root.data; // root.data = root.left + root.right
        } 
        
        return result;
	}
	
	boolean isSumTree(Node root){
	    return isSumTreeFast(root).isSumTree;
	}
}
