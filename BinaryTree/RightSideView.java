package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public void rightSideViewUtil(TreeNode root, int level, List<Integer> result){
        if(root == null)
            return;
        if(level == result.size())
            result.add(root.val);
        
        rightSideViewUtil(root.right, level + 1, result);
        rightSideViewUtil(root.left, level + 1, result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightSideViewUtil(root, 0, result);
        return result;
    }
}
