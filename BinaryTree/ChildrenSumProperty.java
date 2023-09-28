package BinaryTree;

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ChildrenSumProperty {
    public int dfs(Node root, int val) {
        if (root == null)
            return 0;

        int left = dfs(root.left, Math.max(root.data, val));
        int right = dfs(root.right, Math.max(root.data, val));

        root.data = left + right;

        return;
    }

    // public static void main(String[] args) {
    // BinaryTree bt = new BinaryTree();
    // Node root = Bbt.createTree();

    // dfs(root, 0);
    // }
}
