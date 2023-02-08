package BinaryTree;

public class MaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSumUtil(Node root, int sum){
        if(root == null)
            return Integer.MIN_VALUE;
        
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        // PostOrder :
        // left
        if(root.left != null)
            leftSum = maxPathSumUtil(root.left, sum);
        
        // right
        if(root.right != null)
            rightSum = maxPathSumUtil(root.right, sum);
        // Node
        int leftAndRightSum = leftSum + rightSum + root.data;

        return Math.max(leftSum, Math.max(rightSum, leftAndRightSum));
    }

    public int maxPathSumUtilI(Node root){
        if(root.left == null && root.right == null){
            max = (max < root.data) ? root.data : max;
            return root.data;
        }

        if(root.left != null){
            int leftSum = maxPathSumUtilI(root.left);
        }
        if(root.right != null){
            int rightSum = maxPathSumUtilI(root.right);
        }

        int currentSum = Math.max()
        max = (max < )

    }
    public int maxPathSum(Node root){

        int max = Integer.MIN_VALUE;
        return maxPathSumUtil(root, Integer.MIN_VALUE);

    }
}
