package binary_tree_preorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();//当作栈使用
        while(!stack.isEmpty() || root != null){
            if (root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return list;
    }

}
