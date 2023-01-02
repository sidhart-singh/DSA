package BinaryTree;

public class Main {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree();

        System.out.println("Count of Good Nodes: " + CountGoodNodes.countGoodNode(root, root.data));;
    }
}