package BinaryTree;

public class isBalanced {
    public int[] isBalancedUtil(Node root){
        // [ isBalanced, height ]
        
        // PostOrder Traversal: Left -> Right -> Node
        
        // BaseCondition
        if(root == null)
            // { isBalanced : true, height : 0 }
            return new int[]{1, 0};
        
        // Left
        int[] left = isBalancedUtil(root.left);
        
        // Right
        int[] right = isBalancedUtil(root.right);
        
        // Node
        int isBalanced = 0;
        if(
            // Conditions for root:currentNode to be balanced: 

            // 1. left and right subtree are balanced
            left[0] == 1 && right[0] == 1 && 
            
            // 2. root is balanced
            Math.abs(left[1] - right[1]) <= 1
        ){
        isBalanced = 1;
        }
            
        // { isBalanced : true, height : 0 }
        return new int[]{ isBalanced, Math.max(left[1], right[1]) + 1};
    }
}
