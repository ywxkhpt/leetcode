package binary_tree_postorder_traversal;

import java.util.*;
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                res.addFirst(root.val);
                stack.push(root);
                root = root.right;
            }else {
                TreeNode node = stack.pop();
                root = node.left;
            }
        }
        return new ArrayList<>(res);
    }

}
