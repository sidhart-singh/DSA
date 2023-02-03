package BinaryTree;

// Java program to find minimum depth
// of a given Binary Tree
import java.util.*;
class GFG
{
	
// A binary Tree node
static class Node
{
	int data;
	Node left, right;
}

// A queue item (Stores pointer to
// node and an integer)
static class qItem
{
	Node node;
	int depth;

	public qItem(Node node, int depth)
	{
		this.node = node;
		this.depth = depth;
	}
}

// Iterative method to find
// minimum depth of Binary Tree
static int minDepth(Node root)
{
	// Corner Case
	if (root == null)
		return 0;

	// Create an empty queue for level order traversal
	Queue<qItem> q = new LinkedList<>();

	// Enqueue Root and initialize depth as 1
	qItem qi = new qItem(root, 0);
	q.add(qi);

	// Do level order traversal
	while (q.isEmpty() == false)
	{
		// Remove the front queue item
		qi = q.peek();
		q.remove();
	
		// Get details of the remove item
		Node node = qi.node;
		int depth = qi.depth;
	
		// If this is the first leaf node seen so far
		// Then return its depth as answer
		if (node.left == null && node.right == null)
			return depth;
	
		// If left subtree is not null,
		// add it to queue
		if (node.left != null)
		{
			qi.node = node.left;
			qi.depth = depth + 1;
			q.add(qi);
		}
	
		// If right subtree is not null,
		// add it to queue
		if (node.right != null)
		{
			qi.node = node.right;
			qi.depth = depth + 1;
			q.add(qi);
		}
	}
	return 0;
}

// Utility function to create a new tree Node
static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = temp.right = null;
	return temp;
}

// Driver Code
public static void main(String[] args)
{
	// Let us create binary tree shown in above diagram
	Node root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);

	System.out.println(minDepth(root));
}
}

