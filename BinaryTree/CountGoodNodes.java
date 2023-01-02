package BinaryTree;

public class CountGoodNodes {

    public static int countGoodNode(Node root, int max){

        // PreOrder Traversal : Node -> Left -> Right

        if(root == null)
            return 0;
        
        // Node
        int count = 0;
        int currentMax = max;
        if(root.data >= max){
            count++;
            currentMax = root.data;
        }

        // Left
        count += countGoodNode(root.left, currentMax);

        // Right
        count += countGoodNode(root.right, currentMax);

        return count;
    }

}
