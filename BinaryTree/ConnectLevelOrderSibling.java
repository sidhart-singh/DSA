package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {}
    
    public TreeNode(int _val) {
        val = _val;
    }
}

public class ConnectLevelOrderSibling {
    
    public static void connect(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);
        deque.offerLast(null);

        while(!deque.isEmpty()){
            TreeNode current = deque.poll();
            TreeNode next = deque.peek();

            if(current == null){
                if(deque.isEmpty()){
                    break;
                }
                deque.add(null);
                continue;
            }

            current.next = next;

            if(current.left != null)
                deque.add(current.left);
            if(current.right != null)
                deque.add(current.right);

        }
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

	// System.out.println(connect(root));
    connect(root);
}
}
