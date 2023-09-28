package BinaryTree;

public class SmallestStringFromLeaf {
    String path = "";
    String result = "";

    public String smallestFromLeaf(Node root) {

        if (root == null)
            return null;

        // add current char to the path
        // adding to the beginning of the string
        path = (char) (root.data + 97) + path;

        // check result
        if (root.left == null && root.right == null) {
            if (result.length() == 0)
                result = path;

            // compareTo() compares strings lexicographically
            if (result.compareTo(path) > 0)
                result = path;

            // result = isLexicallySmaller(result, path);
        }

        // left
        smallestFromLeaf(root.left);

        // right
        smallestFromLeaf(root.right);

        // remove the current char from the path : first char
        // since we added the char at the beginning
        path = path.substring(1);

        // return result;
    }

    public String isLexicallySmaller(String s1, String s2) {

        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) < s2.charAt(j)) {
                return s1;
            }
            if (s1.charAt(i) > s2.charAt(j)) {
                return s2;
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
        }
        if (i == s1.length())
            return s1;
        else
            return s2;

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree();

        SmallestStringFromLeaf sssfl = new SmallestStringFromLeaf();
        System.out.println(sssfl.smallestFromLeaf(root));
    }
}
