package BinaryTree;


/*
 * INCORRECT : return 1 less than the correct result
 */
public class Diameter {

    int height(Node root){
        if(root == null)
            return 0;
            
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
    
    int diameterSlow(Node root) {
        if(root == null)
            return 0;
        
        // diameter in left subtree
        int left = diameterSlow(root.left);
        
        // diameter in right subtree
        int right = diameterSlow(root.right);
        
        // diameter in left and right subtree together
        int leftAndRight = height(root.left) + height(root.right) + 1;
        
        return Math.max(left, Math.max(right, leftAndRight));
    }

    class Pair{
        int diameter;
        int height;
        
        Pair(int d, int h){
            this.diameter = d;
            this.height = h;
        }
    }

    Pair diameterFast(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
            
        Pair left = diameterFast(root.left);
        Pair right = diameterFast(root.right);
        
        int leftD = left.diameter;
        int rightD = right.diameter;
        int comboD = left.height + right.height + 1;
        
        Pair result = new Pair(0, 0);
        result.diameter = Math.max(leftD, Math.max(rightD, comboD));
        result.height = Math.max(left.height, right.height) + 1;
        
        return result;
    }
    
    int diameter(TreeNode root){
        return diameterFast(root).diameter;
    }

    public static TreeNode newTreeNode(int value){
        return new TreeNode(value);
    }

    public static void main(String[] args)
{
	// Let us create binary tree shown in above diagram
	TreeNode root = newTreeNode(1);
	root.left = newTreeNode(2);
	root.right = newTreeNode(3);
	root.left.left = newTreeNode(4);
	root.left.right = newTreeNode(5);

    Diameter d = new Diameter();
    System.out.println(d.diameter(root));    
}
}
